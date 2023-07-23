package com.tmoh.demoeasticsearch.service;

import com.tmoh.demoeasticsearch.domain.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<Book> getAll();

    Book add(Book book);

    Book getById(String id);

    Book update(Book book, String id);

    void deleteById(String id);
}
