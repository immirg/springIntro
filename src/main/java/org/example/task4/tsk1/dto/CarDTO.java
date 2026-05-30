package org.example.task4.tsk1.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.example.task4.tsk1.views.Views;

@Data
public class CarDTO {
    @JsonView(Views.Level1.class)
    private Integer carId;
    @JsonView({Views.Level1.class, Views.Level2.class})
    private double carPower;
    @JsonView({Views.Level1.class, Views.Level2.class, Views.Level3.class})
    private String carModel;
    @JsonView({Views.Level1.class, Views.Level2.class, Views.Level3.class})
    private String carProducer;
    private String carImageName;

    public CarDTO(Integer carId, String carModel, String carProducer, double carPower, String carImageName) {
        this.carId = carId;
        this.carModel = carModel;
        this.carProducer = carProducer;
        this.carPower = carPower;
        this.carImageName = carImageName;
    }
}
