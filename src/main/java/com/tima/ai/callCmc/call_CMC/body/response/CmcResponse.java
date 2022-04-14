package com.tima.ai.callCmc.call_CMC.body.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CmcResponse {

    @JsonProperty("success")
    public String success;

    @JsonProperty("transID")
    public String transID;

    @JsonProperty("data")
    public Ddata data;

    @JsonProperty("title")
    private String title;

    @JsonProperty("message")
    private String message;

    @Data
    public static class Ddata{
        @JsonProperty("packagePeriod")
        public PackagePeriod packagePeriod;
    }

    @Data
    public static class PackagePeriod{
        @JsonProperty("0")
        public String first;

        @JsonProperty("1")
        public String second;

        @JsonProperty("2")
        public String third;
    }

}
