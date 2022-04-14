package com.tima.ai.callCmc.call_CMC.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    public static <R> Optional<R> jsonToObject(String jsonString, Class<R> returnClass){
        if (jsonString == null)
            return Optional.empty();
        try {
            return Optional.of(objectMapper.readValue(jsonString, returnClass));
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static <T> Optional<String> objectToJson(T object){
        try {
            return Optional.of(objectMapper.writeValueAsString(object));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public static String getHvDetailMessage(Object object){
        HashMap<String, String> hvDetail = null;
        if (object instanceof List){
            hvDetail = (HashMap<String, String>) ((List<?>) object).get(0);
        } else {
            hvDetail = (HashMap<String, String>) object;
        }
        return hvDetail.get("message");
    }

    public static String getHvDetailCode(Object object){
        HashMap<String, String> hvDetail = null;
        if (object instanceof List){
            hvDetail = (HashMap<String, String>) ((List<?>) object).get(0);
        } else {
            hvDetail = (HashMap<String, String>) object;
        }
        return hvDetail.get("code");
    }

}
