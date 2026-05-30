package org.example.task4.tsk2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.task4.tsk2.entity.Car;
import org.example.task4.tsk2.dto.CarDTO;
import org.example.task4.tsk2.service.CarService;
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

    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return carService.findAllCars();
    }

    @PostMapping("/cars")
    public ResponseEntity<Void> saveCar(@RequestBody @Valid Car car){
        return carService.addNewCar(car);
    }

    @GetMapping("cars/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable String id) {
        return carService.findCarById(id);
    }

    @GetMapping("cars/power/{value}")
    public ResponseEntity<List<CarDTO>> getCarsByPower(@PathVariable double value) {
        return carService.findCarsByPower(value);
    }

    @GetMapping("cars/producer/{value}")
    public ResponseEntity<List<CarDTO>> getCarsByProducer(@PathVariable String value) {
        return carService.findByProducer(value);
    }

    @DeleteMapping("cars/{id}")
    public ResponseEntity<Void> removeCarById(@PathVariable String id) {
        return carService.removeCarById(id);
    }

    @DeleteMapping("cars/power/{value}")
    public ResponseEntity<Void> removeCarsWithPowerLessThanSpecified(@PathVariable double value) {
        return carService.removeCarsWithPowerLessThan(value);
    }
}
