package org.example.task1;

import lombok.Data;

import java.util.UUID;

@Data
public class Car {
    private Long id;
    private String model;
    private String producer;
    private double power;

    public Car(Long id, String model, String producer, double power) {
        this.id = id;
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
}
