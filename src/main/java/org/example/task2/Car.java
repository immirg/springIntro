package org.example.task2;

import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String producer;
    private double power;

    public Car(String model, String producer, double power) {
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
    public Car() {}
}
