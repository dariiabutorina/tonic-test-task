package com.dev.integration.model;

import java.util.Arrays;

public enum Operation {
    APPEND("append"),
    DIVIDE("divide"),
    MULTIPLY("multiply"),
    POWER("power"),
    REDUCE("reduce");
    public final String label;
    Operation(String label) {
        this.label = label;
    }

    public static Operation valueOfLabel(String label) {
        return Arrays.stream(Operation.values())
                .filter(operation -> operation.label.equals(label)).findFirst().get();
    }
}
