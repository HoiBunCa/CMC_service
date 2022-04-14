package com.tima.ai.callCmc.call_CMC.body.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.sql.Timestamp;
import com.tima.ai.callCmc.call_CMC.body.response.CmcResponse;

@Data
@ToString
public class SimpleResponse {
    @ApiModelProperty(value = "mã lỗi, 200: Success, 500: Error ")
    @JsonProperty("status")
    protected int status;

    @ApiModelProperty(value = "Mô tả lỗi")
    @JsonProperty("desc")
    protected String desc;

    @ApiModelProperty(value = "Thời gian")
    @JsonProperty("timestamp")
    protected Timestamp timestamp;

    @ApiModelProperty(value = "Response")
    @JsonProperty("response")
    protected CmcResponse response;

}
