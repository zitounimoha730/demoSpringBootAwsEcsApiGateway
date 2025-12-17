package com.example.demobooksspringbootapi.domain.common.entities;

import org.apache.commons.lang3.StringUtils;

public interface DefaultDomainResponse <U> {
    U entity();
    String error();

    default boolean isValid() {
        return StringUtils.isEmpty(error());
    }
}