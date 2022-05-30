package com.dev.integration.service.command;

import com.dev.integration.model.Operation;

public interface Calculating {
    Integer calculate(Integer currentResult, Integer number);

    Operation getOperation();
}
