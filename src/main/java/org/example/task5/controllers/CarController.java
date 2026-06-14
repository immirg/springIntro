package org.example.task5.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.example.task5.dto.CarDTO;
import org.example.task5.entity.Car;
import org.example.task5.services.CarService;
import org.example.task5.views.Views;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @JsonView(Views.User.class)
    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return carService.findAllCars();
    }

    @JsonView(Views.Manager.class)
    @PostMapping("/cars")
    public ResponseEntity<Void> saveCar(@RequestBody @Valid Car car){
        return carService.addNewCar(car);
    }

    @JsonView(Views.User.class)
    @GetMapping("cars/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Integer id) {
        return carService.findCarById(id);
    }

    @JsonView(Views.User.class)
    @GetMapping("cars/power/{value}")
    public ResponseEntity<List<CarDTO>> getCarsByPower(@PathVariable double value) {
        return carService.findCarsByPower(value);
    }

    @JsonView(Views.User.class)
    @GetMapping("cars/producer/{value}")
    public ResponseEntity<List<CarDTO>> getCarsByProducer(@PathVariable String value) {
        return carService.findByProducer(value);
    }

    @JsonView(Views.Admin.class)
    @DeleteMapping("cars/{id}")
    public ResponseEntity<Void> removeCarById(@PathVariable Integer id) {
        return carService.removeCarById(id);
    }

    @JsonView(Views.Admin.class)
    @DeleteMapping("cars/power/{value}")
    public ResponseEntity<Void> removeCarsWithPowerLessThanSpecified(@PathVariable double value) {
        return carService.removeCarsWithPowerLessThan(value);
    }
}
