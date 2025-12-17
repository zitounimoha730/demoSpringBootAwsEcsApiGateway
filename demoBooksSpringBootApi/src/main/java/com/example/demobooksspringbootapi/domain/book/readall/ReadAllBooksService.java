package com.example.demoawsspringboot.domain.book.readall;

import com.example.demoawsspringboot.domain.book.entity.Book;
import com.example.demoawsspringboot.domain.book.readall.entity.ReadAllBooksCommand;
import com.example.demoawsspringboot.domain.book.readall.entity.ReadAllBooksResponse;
import com.example.demoawsspringboot.domain.book.readall.ports.ReadAllBooksRepository;
import com.example.demoawsspringboot.domain.book.readall.ports.ReadAllBooksUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReadAllBooksService implements ReadAllBooksUseCase {
    private final ReadAllBooksRepository repository;
    @Override
    public Mono<ReadAllBooksResponse> process(ReadAllBooksCommand command) {
        return fetchAll()
                .doOnError(th -> log.atError().log("Error while reading all books", th))
                .map(ReadAllBooksResponse::defaultResponse)
                .onErrorResume(th -> Mono.just(ReadAllBooksResponse.errorResponse(th.getMessage())));
    }

    private Mono<List<Book>> fetchAll() {
        return repository.fetchAll()
                .doOnError(th -> log.atWarn().log("Error while reading books from database!", th));
    }
}
