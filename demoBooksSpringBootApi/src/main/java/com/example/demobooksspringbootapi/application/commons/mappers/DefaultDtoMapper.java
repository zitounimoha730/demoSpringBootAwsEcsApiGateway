package com.example.demobooksspringbootapi.application.common.mapper;

import java.util.List;

public interface DefaultDtoMapper<T, V> {
    T toDomainEntity(V dto);
    V toDto(T entity);
    List<T> toDomainEntityList(List<V> dto);
    List<V> toDtoList(List<T> entities);
}