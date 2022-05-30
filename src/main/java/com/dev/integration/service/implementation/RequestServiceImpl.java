package com.dev.integration.service.implementation;

import com.dev.integration.exception.UnexpectedHttpStatusException;
import com.dev.integration.service.interfaces.RequestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class RequestServiceImpl implements RequestService {
    private static final String HEAD_URL = "https://dummy.com/api/";
    private static final String TAIL_URL = "/result";
    private static final String FIRST_HEADER_KEY = "Accept-Language";
    private static final String FIRST_HEADER_VALUE = "en-US";
    private static final String SECOND_HEADER_KEY = "Operation-Number";
    private static final String BODY_KEY = "result";
    private final Logger logger;


    @Autowired
    public RequestServiceImpl() {
        logger = Logger.getLogger(RequestServiceImpl.class);
    }

    @Override
    public void sendResultHttpRequest(Integer result, Integer operationNumber) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set(FIRST_HEADER_KEY, FIRST_HEADER_VALUE);
        headers.set(SECOND_HEADER_KEY, operationNumber.toString());
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Map<String, Object> bodyParameters = new HashMap<>();
        bodyParameters.put(BODY_KEY, result);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(bodyParameters, headers);
        ResponseEntity<String> response = restTemplate
                .postForEntity(HEAD_URL + operationNumber + TAIL_URL,
                entity, String.class);
        validateResponse(response, HttpStatus.OK);
    }

    private void validateResponse(ResponseEntity<String> response, HttpStatus expectedStatus) {
        if (response.getStatusCode() != expectedStatus) {
            throw new UnexpectedHttpStatusException("Request Failed: " + response.getStatusCode());
        }

        logger.info("Request Successful: " + response.getBody());
    }
}
