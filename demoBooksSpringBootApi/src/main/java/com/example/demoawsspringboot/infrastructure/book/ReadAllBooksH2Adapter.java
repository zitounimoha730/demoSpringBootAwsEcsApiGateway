package com.example.demoawsspringboot.infrastructure.book;

import com.example.demoawsspringboot.domain.book.entity.Book;
import com.example.demoawsspringboot.domain.book.readall.ports.ReadAllBooksRepository;
import com.example.demoawsspringboot.infrastructure.common.mappers.BookEntityMapper;
import com.example.demoawsspringboot.infrastructure.common.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

import static com.example.demoawsspringboot.domain.common.utils.ReactiveUtils.MAP_INFRA_EXCEPTION;

@RequiredArgsConstructor
@SecondaryAdapter
@Service
public class ReadAllBooksH2Adapter implements ReadAllBooksRepository {
    private final BookRepository repository;
    private final BookEntityMapper mapper = Mappers.getMapper(BookEntityMapper.class);

    @Override
    public Mono<List<Book>> fetchAll() {
        return Mono.fromCallable(repository::findAll)
                .flatMapMany(Flux::fromIterable)
                .map(mapper::toDomain)
                .collectList()
                .subscribeOn(Schedulers.boundedElastic())
                .onErrorMap(MAP_INFRA_EXCEPTION);
    }
}
