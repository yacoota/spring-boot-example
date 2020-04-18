package com.cacoota.business.mapper;

import com.cacoota.business.model.SearchDemo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchDemoRepository extends ElasticsearchRepository<SearchDemo, Long> {

}
