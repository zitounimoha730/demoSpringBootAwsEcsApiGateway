package com.example.demoawsspringboot.infrastructure.book;

import com.example.demoawsspringboot.domain.book.create.ports.CreateBookRepository;
import com.example.demoawsspringboot.domain.book.entity.Book;
import com.example.demoawsspringboot.infrastructure.common.mappers.BookEntityMapper;
import com.example.demoawsspringboot.infrastructure.common.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static com.example.demoawsspringboot.domain.common.utils.ReactiveUtils.MAP_INFRA_EXCEPTION;

@RequiredArgsConstructor
@SecondaryAdapter
@Service
public class CreateBookH2Adapter implements CreateBookRepository {
    private final BookRepository repository;
    private final BookEntityMapper mapper = Mappers.getMapper(BookEntityMapper.class);


    @Override
    public Mono<Book> save(Book book) {
        return Mono.fromCallable(() -> repository.save(mapper.toEntity(book)))
                .subscribeOn(Schedulers.boundedElastic())
                .map(mapper::toDomain)
                .onErrorMap(MAP_INFRA_EXCEPTION);
    }
}
