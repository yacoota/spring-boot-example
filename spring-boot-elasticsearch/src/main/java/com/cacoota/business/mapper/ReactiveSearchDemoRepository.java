package com.cacoota.business.mapper;

import com.cacoota.business.model.SearchDemo;
import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository;

public interface ReactiveSearchDemoRepository extends ReactiveElasticsearchRepository<SearchDemo, Long> {

}
