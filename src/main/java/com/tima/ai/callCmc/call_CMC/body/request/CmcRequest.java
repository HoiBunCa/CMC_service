package com.tima.ai.callCmc.call_CMC.body.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class CmcRequest {

    @JsonProperty("msisdn")
    String msisdn;


}
