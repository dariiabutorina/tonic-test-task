package com.dev.integration.controller;

import com.dev.integration.dto.CalculatorDto;
import com.dev.integration.service.interfaces.CalculatorService;
import com.dev.integration.service.interfaces.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
@RequiredArgsConstructor
public class CalculatorController {
    private final CalculatorService calculatorService;
    private final RequestService requestService;

    @PostMapping
    public void operateNumbers(@RequestBody CalculatorDto calculatorDto) {
        requestService.sendResultHttpRequest(calculatorService.calculate(calculatorDto),
                calculatorDto.getOperation_number());
    }
}
