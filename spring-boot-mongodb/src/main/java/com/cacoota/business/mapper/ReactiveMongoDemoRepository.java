package com.cacoota.business.mapper;

import com.cacoota.business.model.MongoDemo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ReactiveMongoDemoRepository extends ReactiveMongoRepository<MongoDemo, Long> {

    Flux<MongoDemo> findByUsername(String username);

}
