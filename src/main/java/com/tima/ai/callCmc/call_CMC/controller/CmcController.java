package com.tima.ai.callCmc.call_CMC.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tima.ai.callCmc.call_CMC.body.response.CmcResponse;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;

import com.tima.ai.callCmc.call_CMC.body.response.SimpleResponse;
import com.tima.ai.callCmc.call_CMC.body.request.SimpleRequest;
import com.tima.ai.callCmc.call_CMC.service.PhoneCheckService;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;


@Log4j2
@Controller
@RequestMapping(path = "/cmc-check")
public class CmcController {

    @Autowired
    PhoneCheckService phoneCheckService;

    @GetMapping(path = "/health-check")
    public @ResponseBody ResponseEntity<SimpleResponse> healthCheck() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/scoring_x3_calling")
    public @ResponseBody
    ResponseEntity<SimpleResponse> checkById(@RequestBody SimpleRequest request) throws JsonProcessingException {
        SimpleResponse response = new SimpleResponse();
        response.setTimestamp(new Timestamp(System.currentTimeMillis()));
        try{
            CmcResponse cmcResponse = phoneCheckService.callApiScoring_x3_Calling(request.getMsisdn());
            response.setResponse(cmcResponse);
            response.setDesc("Success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            response.setDesc("Lỗi service, vui lòng liên hệ admin.");
            log.error("scoring_x3_calling ERROR " + e.toString());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
