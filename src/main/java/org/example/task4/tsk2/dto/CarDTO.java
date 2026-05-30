package org.example.task4.tsk2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    private String carId;
    private String carModel;
    private String carProducer;
    private Double carPower;
}
