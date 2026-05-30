package org.example.task4.tsk2.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cars")
@NoArgsConstructor
public class Car {
    @Id
    private String id;
    @NotNull(message = "model is required")
    private String model;
    @NotNull(message = "producer is required")
    private String producer;
    @Min(60)
    @Max(560)
    private double power;

    public Car(String model, String producer, double power) {
        this.id = null;
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
}
