package com.tima.ai.callCmc.call_CMC.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.tima.ai.callCmc.call_CMC.body.request.CmcRequest;
import com.tima.ai.callCmc.call_CMC.body.response.CmcResponse;
import com.tima.ai.callCmc.call_CMC.model.entity.CmcLog;
import com.tima.ai.callCmc.call_CMC.model.repo.CmcLogRepo;
import com.tima.ai.callCmc.call_CMC.utils.JsonUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;


@Log4j2
@Service
public class PhoneCheckService {

    public static final String URL_API_SCORING_X3_CALLING = "http://203.171.20.122:8081/API/ITRUST/CALLCS3";
    public static final String token = "test";

    ObjectMapper map = new ObjectMapper();

    @Autowired
    CmcLogRepo cmcLogRepo;

    public HttpHeaders getHeaderRequest(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public CmcResponse callApiScoring_x3_Calling(String msisdn) throws JsonProcessingException {

        CmcResponse result = new CmcResponse();

        HttpHeaders headers = getHeaderRequest();
        CmcRequest cmc_request = new CmcRequest();
        cmc_request.setMsisdn(msisdn);

        List<CmcLog> cmcLogs = cmcLogRepo.select_all(msisdn);
        if (cmcLogs.size() == 0){
            log.info("New msisdn");
            HttpEntity<CmcRequest> request = new HttpEntity<>(cmc_request, headers);
//            ResponseLocationCodeV2_sentSMS result = restTemplate.postForObject(URL_API_SCORING_X3_CALLING, request, ResponseLocationCodeV2_sentSMS.class);
//
//            succes = true
            result.setSuccess("TRUE");
            result.setTransID("test_transid");
            CmcResponse.PackagePeriod packagePeriod = new CmcResponse.PackagePeriod();
            packagePeriod.setFirst("1000");
            packagePeriod.setSecond("2000");
            packagePeriod.setThird("3000");
            CmcResponse.Ddata ddata = new CmcResponse.Ddata();
            ddata.setPackagePeriod(packagePeriod);
            result.setData(ddata);

//            // succes = false
//
//            result.setSuccess("FALSE");
//            result.setTransID("test_transid");
//            result.setTitle("NO_DATA");
//            result.setMessage("No data.");


            CmcLog cmcLog = new CmcLog();
            cmcLog.setPhone(msisdn);
            cmcLog.setApiType("Scoring_x3_Calling");
            cmcLog.setApiUrl(URL_API_SCORING_X3_CALLING);
            cmcLog.setTransId(result.getTransID());
            cmcLog.setBody(map.writeValueAsString(cmc_request));
            cmcLog.setResponse(map.writeValueAsString(result));
            cmcLog.setTimestamp(new Timestamp(System.currentTimeMillis()));
            cmcLog.setStatus(result.getSuccess());
            cmcLogRepo.save(cmcLog);
            return result;
        }
        else{
            return JsonUtils.jsonToObject(cmcLogs.get(0).getResponse(), CmcResponse.class).get();
        }
    }
}