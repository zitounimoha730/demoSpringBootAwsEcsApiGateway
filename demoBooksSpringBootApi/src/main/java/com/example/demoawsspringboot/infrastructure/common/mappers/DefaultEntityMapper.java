package com.example.demoawsspringboot.infrastructure.common.mappers;

import java.util.List;

public interface DefaultEntityMapper<T, V> {
    T toDomain(V entity);
    V toEntity(T domain);
    List<T> toDomainList(List<V> entities);
    List<V> toEntityList(List<T> entities);
}
