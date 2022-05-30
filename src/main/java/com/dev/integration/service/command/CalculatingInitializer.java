package com.dev.integration.service.command;

import com.dev.integration.model.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class CalculatingInitializer {
    private final List<Calculating> commands;

    @Bean
    public Map<Operation, Calculating> getCommands() {
        return commands.stream()
                .collect(Collectors.toMap(Calculating::getOperation, Function.identity()));
    }
}

