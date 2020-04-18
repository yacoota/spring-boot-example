package com.cacoota.business.service;

import com.cacoota.business.model.MongoDemo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MongoDemoService {

    Mono<MongoDemo> insert(MongoDemo demo);

    Mono<MongoDemo> save(MongoDemo demo);

    Flux<MongoDemo> find(String name);

}
