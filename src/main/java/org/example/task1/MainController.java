package org.example.task1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final CarService carService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.findAllCars();
    }
    @GetMapping("/cars/{id}")
    public Optional<Car> getCarById(@PathVariable Long id) {
        return carService.findById(id);
    }
    @PostMapping({"/cars"})
    public String createNewCar(@RequestBody Car car) {
        return carService.newCar(car);
    }
    @DeleteMapping("/cars/{id}")
    public String removeCarById(@PathVariable Long id) {
        return carService.removeById(id);
    }
    @GetMapping("/cars/power/{value}")
    public List<Car> getCarByPower(@PathVariable double value) {
        return carService.findByPower(value);
    }
    @GetMapping("/cars/producer/{value}")
    public List<Car> getCarByProducer(@PathVariable String value) {
        return carService.findByProducer(value);
    }
}
