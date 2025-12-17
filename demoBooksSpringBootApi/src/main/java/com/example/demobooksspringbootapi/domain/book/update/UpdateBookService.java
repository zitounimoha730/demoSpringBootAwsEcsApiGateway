package com.example.demobooksspringbootapi.domain.book.update;

import com.example.demobooksspringbootapi.domain.book.commons.entity.Book;
import com.example.demobooksspringbootapi.domain.book.update.entity.UpdateBookCommand;
import com.example.demobooksspringbootapi.domain.book.update.entity.UpdateBookHelperModel;
import com.example.demobooksspringbootapi.domain.book.update.entity.UpdateBookResponse;
import com.example.demobooksspringbootapi.domain.book.update.ports.UpdateBookRepository;
import com.example.demobooksspringbootapi.domain.book.update.ports.UpdateBookUseCase;
import com.example.demobooksspringbootapi.domain.commons.errors.DomainException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static com.example.demobooksspringbootapi.domain.book.commons.constants.BookConstants.EXPENSIVE_BOOKS_PRICE;
import static com.example.demobooksspringbootapi.domain.book.commons.constants.BookConstants.INVALID_BOOK_PRICE_ERROR_MESSAGE;

@Service
@AllArgsConstructor
@Slf4j
public class UpdateBookService implements UpdateBookUseCase {
    private final UpdateBookRepository repository;
    private static final String EXPENSIVE_BOOKS = "EXPENSIVE";
    @Override
    public Mono<UpdateBookResponse> process(UpdateBookCommand command) {
        return validate(command.get())
                .flatMap(this::buildUpdatedBook)
                .flatMap(this::saveBook)
                .doOnError(th -> log.atError().log("Error updating book!", th))
                .map(UpdateBookResponse::defaultResponse)
                .onErrorResume(th -> Mono.just(UpdateBookResponse.errorResponse(th.getMessage())));
    }

    private Mono<Book> buildUpdatedBook(Book book) {
        return this.retrieveExistingBook(book.id())
                .map(existing -> new UpdateBookHelperModel(book, existing))
                .map(model -> new UpdateBookHelper(model).updatedBook());
    }

    private Mono<Book> retrieveExistingBook(Long id) {
        return this.repository.findById(id)
                .doOnError(th -> log.atWarn().log("Error while finding existing book id: %s".formatted(id), th));
    }

    private Mono<Book> saveBook(Book book) {
        return repository.save(book)
                .doOnError(th -> log.atWarn().log("Error while saving book in database!", th));
    }

    private Mono<Book> validate(Book book) {
        if(book.title().toUpperCase().startsWith(EXPENSIVE_BOOKS) && book.price() < EXPENSIVE_BOOKS_PRICE) {
            return Mono.error( new DomainException(INVALID_BOOK_PRICE_ERROR_MESSAGE));
        }
        return Mono.just(book);
    }
}
