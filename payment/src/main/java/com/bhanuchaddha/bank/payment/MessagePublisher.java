package com.bhanuchaddha.bank.payment;

/**
 * Created by ben on 07-12-2018 12:20 AM.
 */
public interface MessagePublisher {
    void publish(Payment payment);
}

