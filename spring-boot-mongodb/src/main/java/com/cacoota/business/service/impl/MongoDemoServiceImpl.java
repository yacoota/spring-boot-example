package com.cacoota.business.service.impl;


import com.cacoota.business.mapper.ReactiveMongoDemoRepository;
import com.cacoota.business.model.MongoDemo;
import com.cacoota.business.service.MongoDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MongoDemoServiceImpl implements MongoDemoService {

    @Autowired
    private ReactiveMongoTemplate template;

    @Autowired
    private ReactiveMongoDemoRepository repository;

    @Override
    public Mono<MongoDemo> insert(MongoDemo demo) {
        return template.save(demo);
    }

    @Override
    public Mono<MongoDemo> save(MongoDemo demo) {
        return repository.save(demo);
    }

    @Override
    public Flux<MongoDemo> find(String name) {
        return repository.findByUsername(name);
    }

}
