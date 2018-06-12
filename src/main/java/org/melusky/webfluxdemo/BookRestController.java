package org.melusky.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book/{id}")
    public Mono<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

}
