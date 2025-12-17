package com.example.demobooksspringbootapi.infrastructure.book;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import com.example.demobooksspringbootapi.domain.book.update.ports.UpdateBookRepository;
import com.example.demobooksspringbootapi.infrastructure.commons.mappers.BookEntityMapper;
import com.example.demobooksspringbootapi.infrastructure.commons.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static com.example.demobooksspringbootapi.domain.commons.utils.ReactiveUtils.MAP_INFRA_EXCEPTION;

@RequiredArgsConstructor
@SecondaryAdapter
@Service
public class UpdateBookH2Adapter implements UpdateBookRepository {
    private final BookRepository repository;
    private final BookEntityMapper mapper = Mappers.getMapper(BookEntityMapper.class);


    @Override
    public Mono<Book> save(Book book) {
        return Mono.fromCallable(() -> repository.save(mapper.toEntity(book)))
                .subscribeOn(Schedulers.boundedElastic())
                .map(mapper::toDomain)
                .onErrorMap(MAP_INFRA_EXCEPTION);
    }

    @Override
    public Mono<Book> findById(Long id) {
        return Mono.fromCallable(() -> repository.findById(id))
                .subscribeOn(Schedulers.boundedElastic())
                .map(mapper::toDomain)
                .onErrorMap(MAP_INFRA_EXCEPTION);
    }
}
