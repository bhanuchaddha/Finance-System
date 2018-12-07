package com.bhanuchaddha.bank.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

/**
 * Created by ben on 07-12-2018 12:21 AM.
 */
@Service
public class RedisMessagePublisher implements MessagePublisher {

    @Autowired
    private RedisTemplate<String, Payment> redisTemplate;
    @Autowired
    private ChannelTopic topic;

    public RedisMessagePublisher() {
    }
    public void publish(Payment message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}
