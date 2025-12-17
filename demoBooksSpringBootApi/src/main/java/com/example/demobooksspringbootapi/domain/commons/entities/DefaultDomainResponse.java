package com.example.demobooksspringbootapi.domain.commons.entities;

import org.apache.commons.lang3.StringUtils;

public interface DefaultDomainResponse <U> {
    U entity();
    String error();

    default boolean isValid() {
        return StringUtils.isEmpty(error());
    }
}