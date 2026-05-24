package org.example.task3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarExceptionDTO {
    private int code;
    private String field;
    private String msg;
}
