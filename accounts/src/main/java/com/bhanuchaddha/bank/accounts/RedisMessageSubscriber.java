package com.bhanuchaddha.bank.accounts;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by ben on 07-12-2018 12:08 AM.
 */
@Service
public class RedisMessageSubscriber implements MessageListener {

    ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private AccountRepository repository;


    public void onMessage(final Message message, final byte[] pattern) {
        try {
            Payment payment = objectMapper.readValue(message.toString(), Payment.class);
            Account fromAccount = repository.findById(payment.getFromAccount()).get();
            Account toAccount = repository.findById(payment.getToAccount()).get();
            fromAccount.setAmount(fromAccount.getAmount().subtract(payment.getAmount()));
            toAccount.setAmount(toAccount.getAmount().add(payment.getAmount()));
            repository.save(fromAccount);
            repository.save(toAccount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Message received: " + new String(message.getBody()));
    }
}
