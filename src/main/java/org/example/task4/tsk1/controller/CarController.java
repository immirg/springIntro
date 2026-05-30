package org.example.task4.tsk1.controller;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.RequiredArgsConstructor;
import org.example.task4.tsk1.dto.CarDTO;
import org.example.task4.tsk1.entity.Car;
import org.example.task4.tsk1.enums.Producer;
import org.example.task4.tsk1.service.CarService;
import org.example.task4.tsk1.views.Views;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @JsonView(Views.Level3.class)
    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return carService.findAllCars();
    }

    @PostMapping("/cars")
    public ResponseEntity<Void> saveNewCar(@RequestParam String model, @RequestParam String producer, @RequestParam double power, @RequestParam("image") MultipartFile file) throws IOException {
        file.transferTo(new File(System.getProperty("user.home") + File.separator + "pictures" + File.separator + file.getOriginalFilename()));
        Car car = new Car(model, producer, power, file.getOriginalFilename());
        return carService.addNewCar(car);
    }

    @JsonView(Views.Level1.class)
    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Integer id) {
        return carService.findCarById(id);
    }

    @JsonView(Views.Level2.class)
    @GetMapping("/cars/power/{value}")
    public ResponseEntity<List<CarDTO>> getCarByPower(@PathVariable double value) {
        return carService.findCarsByPower(value);
    }

    @JsonView(Views.Level2.class)
    @GetMapping("/cars/producer/{value}")
    public ResponseEntity<List<CarDTO>> getCarByProducer(@PathVariable Producer value) {
        return carService.findCarsByProducer(value);
    }

    @JsonView(Views.Level1.class)
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> removeCarById(@PathVariable Integer id) {
        return carService.removeCarById(id);
    }
}
