package com.tmoh.demoeasticsearch.service;

import com.tmoh.demoeasticsearch.domain.Book;
import com.tmoh.demoeasticsearch.exception.DataNotFoundException;
import com.tmoh.demoeasticsearch.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Spliterators;
import java.util.stream.StreamSupport;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Book> getAll() {
        return StreamSupport
                .stream(Spliterators.spliteratorUnknownSize(
                        repository.findAll().iterator(), 0), false)
                .toList();
    }

    @Override
    public Book add(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getById(String id) {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException("Book id not found"));
    }

    @Override
    public Book update(Book book, String id) {
        repository.findById(id)
                .ifPresentOrElse(book1 -> {
                    book1.setTitle(book.getTitle());
                    book1.setIsbn(book.getIsbn());
                    book1.setDescription(book.getDescription());
                    book1.setLanguage(book.getLanguage());
                    book1.setPage(book.getPage());
                    book1.setPrice(book.getPrice());
                    repository.save(book1);
                },() -> {throw new DataNotFoundException("Book id not found");});

        return book;
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
