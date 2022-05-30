package com.dev.integration.dto;

import lombok.Data;

import java.util.List;

@Data
public class CalculatorDto {
    private Integer operation_number;
    private List<OperationDataDto> input_array;
}
