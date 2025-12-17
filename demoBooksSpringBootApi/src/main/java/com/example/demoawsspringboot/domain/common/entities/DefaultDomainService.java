package com.example.demoawsspringboot.domain.common.entities;

import reactor.core.publisher.Mono;

public interface DefaultDomainService<U, V> {
    Mono<V> process(U command);
}
