package org.melusky.webfluxdemo;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private List<Book> bookList;

    public BookRepositoryImpl() {
        this.bookList = new ArrayList<>();
        bookList.add(new Book(1L, "32340928430", "Of mice and Men"));
        bookList.add(new Book(2L, "23432432", "Clean Code"));
        bookList.add(new Book(3L, "2374932847983274", "Pride and Prejudice"));
    }

    @Override
    public Mono<Book> findById(Long id) {
        return Mono.just(bookList.stream().filter(o -> o.getId() == id).findFirst().get());
    }

    @Override
    public Flux<Book> findAll() {
        return Flux.fromIterable(bookList);
    }
}
