package com.tima.ai.callCmc.call_CMC.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "log_call_cmc")
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class CmcLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer id;

    @Column(name="phone")
    public String phone;

    @Column(name="api_type")
    public String apiType;

    @Column(name="api_url")
    public String apiUrl;

    @Column(name="transid")
    public String transId;

    @Column(name="body")
    public String body;

    @Column(name="response")
    public String response;

    @Column(name="timestamp")
    public Timestamp timestamp;

    @Column(name="status")
    public String status;

}
