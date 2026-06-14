package org.example.task5.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.task5.views.Views;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {
    @JsonView(Views.User.class)
    private Integer carId;
    @JsonView(Views.User.class)
    private String carModel;
    @JsonView(Views.User.class)
    private String carProducer;
    @JsonView(Views.User.class)
    private Double carPower;
}
