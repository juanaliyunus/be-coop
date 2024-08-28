package com.enigmacamp.enigmacoop.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="payment")
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "token")
    private String token;
    @Column(name = "redirect_url")
    private String redirectUrl;
    @Column(name = "transaction_status")
    private String transactionStatus;
    @OneToOne(mappedBy = "payment")
    private LoanPayment loanPayment;
}
