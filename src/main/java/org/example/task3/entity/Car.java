package org.example.task3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.task3.enums.Model;
import org.example.task3.enums.Producer;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name="cars")
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
    @Max(650)
    private double power;

    public Car(Integer id, String model, String producer, double power) {
        this.id = id;
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
}
