package com.cacoota.business.service;

import com.cacoota.business.model.SearchDemo;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

public interface SearchDemoService {

    String insert(SearchDemo demo);

    SearchDemo save(SearchDemo demo);

    Iterable<SearchDemo> find(String name);

    Iterable<SearchDemo> matchSearch(MatchQueryBuilder builder);

    Page<SearchDemo> nativeSearch(NativeSearchQueryBuilder builder);
}

