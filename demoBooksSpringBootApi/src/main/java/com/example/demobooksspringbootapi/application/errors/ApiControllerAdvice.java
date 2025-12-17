package com.example.demobooksspringbootapi.application.error;

import com.example.demobooksspringbootapi.application.error.exception.FunctionnalErrorException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import static java.util.stream.Collectors.joining;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public final class ApiControllerAdvice {

    @ExceptionHandler(WebExchangeBindException.class)
    Mono<ResponseEntity<String>> invalidRequestHandler(WebExchangeBindException e) {
        return Mono.just(ResponseEntity.badRequest().body(e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(joining(" "))));
    }

    @ExceptionHandler({ServerWebInputException.class})
    Mono<ResponseEntity<String>> invalidRequestHandler(ServerWebInputException e) {
        return Mono.just(ResponseEntity.badRequest().body(e.getMessage()));
    }

    @ExceptionHandler({ConversionFailedException.class})
    Mono<ResponseEntity<String>> invalidRequestHandler(ConversionFailedException e) {
        return Mono.just(ResponseEntity.badRequest().body(e.getMessage()));
    }

    @ExceptionHandler({ FunctionnalErrorException.class })
    Mono<ResponseEntity<String>> internalErrorHandler(RuntimeException e) {
        return Mono.just(ResponseEntity.internalServerError().body(e.getMessage()));
    }

}
