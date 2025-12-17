package com.example.demobooksspringbootapi.domain.commons.entities;

import reactor.core.publisher.Mono;

public interface DefaultDomainService<U, V> {
    Mono<V> process(U command);
}
