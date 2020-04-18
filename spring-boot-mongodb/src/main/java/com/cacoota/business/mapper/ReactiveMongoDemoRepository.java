package com.cacoota.business.mapper;

import com.cacoota.business.model.MongoDemo;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface ReactiveMongoDemoRepository extends ReactiveSortingRepository<MongoDemo, Long> {

    Flux<MongoDemo> findByUsername(String username);

}
