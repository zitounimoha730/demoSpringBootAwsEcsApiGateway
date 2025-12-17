package com.example.demoawsspringboot.domain.common.utils;

import com.example.demoawsspringboot.domain.common.errors.InfrastructureException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.function.UnaryOperator;

@UtilityClass
@Slf4j
public class ReactiveUtils {
    public static final UnaryOperator<Throwable> MAP_INFRA_EXCEPTION = InfrastructureException::new;
}
