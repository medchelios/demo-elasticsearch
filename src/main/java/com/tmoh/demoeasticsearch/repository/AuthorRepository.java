package com.tmoh.demoeasticsearch.repository;

import com.tmoh.demoeasticsearch.domain.Author;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends ElasticsearchRepository<Author, String> {
}
