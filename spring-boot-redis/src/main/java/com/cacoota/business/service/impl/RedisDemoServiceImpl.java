package com.cacoota.business.service.impl;


import com.cacoota.business.service.RedisDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class RedisDemoServiceImpl implements RedisDemoService {

    @Autowired
    private ReactiveRedisTemplate<String, String> template;

    @Override
    public Mono save(String key, String value) {
        return template.opsForValue().set(key, value);
    }

    @Override
    public Mono find(String key) {
        return template.opsForValue().get(key);
    }

    @Override
    public Flux show(String[] data) {
        return Flux.just(data).flatMap(s -> template.opsForValue().get(s));
    }


    @Override
    public Mono publishTo(String key, String value) {
        return template.convertAndSend(key, value);
    }

    @Override
    public Flux subscribeOn(String... channels) {
        return template.listenToChannel(channels);
    }

}
