package com.bhanuchaddha.bank.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

/**
 * Created by ben on 07-12-2018 12:30 AM.
 *
 * Handle the event related to Payment Repository
 */
@Component // required to make it active
@RepositoryEventHandler(Payment.class)
public class PaymentEventHandler {

    @Autowired
    private RedisMessagePublisher publisher;



    @HandleAfterCreate
    public void handlePaymentSave( Payment payment) {
        publisher.publish(payment);
    }
}
