package com.example.demoarchitecturehexagonal.infrastructure.book;

import com.example.demoarchitecturehexagonal.domain.book.commons.entity.Book;
import com.example.demoarchitecturehexagonal.domain.book.update.ports.UpdateBookRepository;
import com.example.demoarchitecturehexagonal.infrastructure.commons.mappers.BookEntityMapper;
import com.example.demoarchitecturehexagonal.infrastructure.commons.repositories.BookMongoRepository;
import lombok.RequiredArgsConstructor;
import org.jmolecules.architecture.hexagonal.SecondaryAdapter;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.example.demoarchitecturehexagonal.domain.commons.utils.ReactiveUtils.MAP_INFRA_EXCEPTION;

@RequiredArgsConstructor
@SecondaryAdapter
@Service
public class UpdateBookMongoAdapter implements UpdateBookRepository {
    private final BookMongoRepository repository;
    private final BookEntityMapper mapper = Mappers.getMapper(BookEntityMapper.class);


    @Override
    public Mono<Book> save(Book book) {
        return repository.save(mapper.toEntity(book))
                .map(mapper::toDomain)
                .onErrorMap(MAP_INFRA_EXCEPTION);
    }

    @Override
    public Mono<Book> findById(String id) {
        return repository.findById(id)
                .map(mapper::toDomain)
                .onErrorMap(MAP_INFRA_EXCEPTION);
    }
}
