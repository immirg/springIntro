package org.example.task3.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.task3.enums.Model;
import org.example.task3.enums.Producer;
import org.example.task3.views.Views;

@Data
@AllArgsConstructor
public class CarDTO {
    @JsonView(Views.Level1.class)
    private Integer id;
    @JsonView({Views.Level1.class, Views.Level2.class})
    private double power;
    @JsonView({Views.Level1.class, Views.Level2.class, Views.Level3.class})
    private String model;
    @JsonView({Views.Level1.class, Views.Level2.class, Views.Level3.class})
    private String producer;

    public CarDTO(Integer id, String model, String producer, double power) {
        this.id = id;
        this.model = model;
        this.producer = producer;
        this.power = power;
    }
}
