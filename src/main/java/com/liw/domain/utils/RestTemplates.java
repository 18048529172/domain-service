package com.liw.domain.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class RestTemplates {

    public static <T> T post(RestTemplate restTemplate,String url,MultiValueMap<String, String> params,Class<T> clazz){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
        ResponseEntity<T> response = restTemplate.postForEntity(url, requestEntity , clazz );
        T result = response.getBody();
        return result;
    }

    public static <T> T postRequestBody(RestTemplate restTemplate, String url, JSONObject param, Class<T> clazz){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<String>(param.toJSONString(),headers);
        ResponseEntity<T> response = restTemplate.postForEntity(url, httpEntity , clazz );
        T result = response.getBody();
        return result;
    }


    public static <T> T get(RestTemplate restTemplate,String url,Class<T> clazz){
        ResponseEntity<T> response = restTemplate.getForEntity(url,clazz);
        T result = response.getBody();
        return result;
    }

}
