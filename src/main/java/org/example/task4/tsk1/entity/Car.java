package org.example.task4.tsk1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private String imageName;

    public Car(String model, String producer, double power, String imageName) {
        this.model = model;
        this.producer = producer;
        this.power = power;
        this.imageName = imageName;
    }
}
