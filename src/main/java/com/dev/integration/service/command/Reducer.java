package com.dev.integration.service.command;

import com.dev.integration.model.Operation;
import org.springframework.stereotype.Service;

@Service
public class Reducer implements Calculating {
    @Override
    public Integer calculate(Integer current_result, Integer number) {
        return current_result - number;
    }

    @Override
    public Operation getOperation() {
        return Operation.REDUCE;
    }
}
