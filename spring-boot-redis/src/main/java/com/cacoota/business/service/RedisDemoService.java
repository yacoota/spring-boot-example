package com.cacoota.business.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RedisDemoService {

    Mono save(String key, String value);

    Mono find(String key);

    Flux show(String[] data);

    Mono publishTo(String key, String value);

    Flux subscribeOn(String... channels);
    
}
