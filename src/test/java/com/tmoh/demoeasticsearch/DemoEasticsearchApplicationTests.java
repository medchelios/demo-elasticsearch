package com.tmoh.demoeasticsearch;

import com.tmoh.demoeasticsearch.domain.Book;
import com.tmoh.demoeasticsearch.repository.AuthorRepository;
import com.tmoh.demoeasticsearch.service.AuthorService;
import com.tmoh.demoeasticsearch.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoEasticsearchApplicationTests {

    private final String TITLE = "Titre book";
    private final int PAGE = 145;
    private final String DESCRIPTION = "Description book";
    private final String LANGUAGE = "Language book";

    private BookService bookService = mock(BookService.class);

    private final Book book = Book
            .builder()
            .id(null)
            .title(TITLE)
            .page(PAGE)
            .description(DESCRIPTION)
            .language(LANGUAGE)
            .price(1200.00)
            .build();

    @Test
    void get_all_book() {
        when(bookService.getAll()).thenReturn(List.of(book));
        Assertions.assertNotNull(bookService.getAll());
    }
}
