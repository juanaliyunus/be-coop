package com.enigmacamp.enigmacoop.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    @JsonProperty("transaction_details")
    private PaymentDetailRequest paymentDetailRequest;
    @JsonProperty("enabled_payments")
    private List<String> paymentMethod;
}
