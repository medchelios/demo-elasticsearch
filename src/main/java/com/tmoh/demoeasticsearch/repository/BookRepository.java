package com.tmoh.demoeasticsearch.repository;

import com.tmoh.demoeasticsearch.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ElasticsearchRepository<Book, String> {
}
