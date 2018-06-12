package org.melusky.webfluxdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    public Mono<ServerResponse> all(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(bookRepository.findAll(), Book.class));
    }

}
