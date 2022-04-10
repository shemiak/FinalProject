package org.finalProject.client.service.impl;

import org.finalProject.client.dto.BalanceDto;
import org.finalProject.client.service.ClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientServiceImpl implements ClientService {

    private final RestTemplate restTemplate;
    private final String serverUrl;
    @Value("${application.cardnumber}")
    private String cardNumber;
    @Value("${application.pincode}")
    private String pinCode;

    public ClientServiceImpl(
            RestTemplate restTemplate, @Value("${application.server.url}") String serverUrl) {
        this.restTemplate = restTemplate;
        this.serverUrl = serverUrl;
    }

    @Override
    public BalanceDto requestBalance() {
        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(cardNumber, pinCode));

        return restTemplate.exchange(
                serverUrl + "/balance",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<BalanceDto>() {
                }
        ).getBody();
    }
}
