package org.example.task5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Data
@Table(name = "cars")
@Entity
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
