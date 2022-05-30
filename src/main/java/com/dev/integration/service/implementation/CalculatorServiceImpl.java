package com.dev.integration.service.implementation;

import com.dev.integration.dto.CalculatorDto;
import com.dev.integration.dto.OperationDataDto;
import com.dev.integration.model.Operation;
import com.dev.integration.service.command.Calculating;
import com.dev.integration.service.interfaces.CalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {
    private final Map<Operation, Calculating> calculatingMap;

    @Override
    public Integer calculate(CalculatorDto calculatorDto) {
        Integer result = 0;
        List<OperationDataDto> operationDataDtoList = calculatorDto.getInput_array();

        for (int i = 0; i < calculatorDto.getOperation_number(); i++) {
            for (OperationDataDto operationDataDto : operationDataDtoList) {
                result = calculatingMap
                        .get(Operation.valueOfLabel(operationDataDto.getCommand()))
                        .calculate(result, operationDataDto.getNumber());
            }
        }

        return result;
    }
}
