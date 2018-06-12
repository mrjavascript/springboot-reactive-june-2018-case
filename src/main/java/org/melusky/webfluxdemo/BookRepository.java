package org.melusky.webfluxdemo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BookRepository {

    Mono<Book> findById(Long id);

    Flux<Book> findAll();


}
