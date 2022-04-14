package com.tima.ai.callCmc.call_CMC.body.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import java.io.Serializable;

@Data
@ToString
public class SimpleRequest implements Serializable {
    @JsonProperty("msisdn")
    public String msisdn;
}
