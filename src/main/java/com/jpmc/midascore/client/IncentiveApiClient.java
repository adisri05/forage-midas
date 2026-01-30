package com.jpmc.midascore.client;

import com.jpmc.midascore.foundation.Incentive;
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IncentiveApiClient {

    private final RestTemplate restTemplate;
    private final String incentiveApiUrl;

    public IncentiveApiClient(RestTemplateBuilder builder,
                             @Value("${incentive.api.url}") String incentiveApiUrl) {
        this.restTemplate = builder.build();
        this.incentiveApiUrl = incentiveApiUrl;
    }

    public float getIncentiveAmount(Transaction transaction) {
        try {
            Incentive incentive = restTemplate.postForObject(incentiveApiUrl, transaction, Incentive.class);
            return incentive != null ? Math.max(0, incentive.getAmount()) : 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
