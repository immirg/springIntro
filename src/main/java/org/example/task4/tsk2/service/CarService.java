package org.example.task4.tsk2.service;

import lombok.RequiredArgsConstructor;
import org.example.task4.tsk2.entity.Car;
import org.example.task4.tsk2.dao.CarDAO;
import org.example.task4.tsk2.dto.CarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CarService {
    private final CarDAO carDAO;

    public ResponseEntity<List<CarDTO>> findAllCars() {
        List<CarDTO> cars = carDAO.findAll().stream().map(car -> new CarDTO(
                car.getId(),
                car.getModel(),
                car.getProducer(),
                car.getPower()
        )).toList();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    public ResponseEntity<CarDTO> findCarById(String id) {
        Car car = carDAO.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        CarDTO carDTO = new CarDTO(
                car.getId(),
                car.getModel(),
                car.getProducer(),
                car.getPower()
        );
        return new ResponseEntity<>(carDTO, HttpStatus.OK);
    }

    public ResponseEntity<List<CarDTO>> findCarsByPower(double power) {
        List<Car> cars = carDAO.findByPower(power);
        if (cars.isEmpty()) {
            throw new RuntimeException("Cars not found");
        }
        List<CarDTO> carsDTO = new ArrayList<>();
        for(Car car: cars) {
            CarDTO carDTO = new CarDTO(
                    car.getId(),
                    car.getModel(),
                    car.getProducer(),
                    car.getPower()
            );
            carsDTO.add(carDTO);
        }
        return new ResponseEntity<>(carsDTO, HttpStatus.OK);
    }

    public ResponseEntity<List<CarDTO>> findByProducer(String producer) {
        List<Car> cars = carDAO.findByProducer(producer);
        if (cars.isEmpty()) {
            throw new RuntimeException("Cars not found");
        }
        List<CarDTO> carsDTO = new ArrayList<>();
        for(Car car: cars) {
            CarDTO carDTO = new CarDTO(
                    car.getId(),
                    car.getModel(),
                    car.getProducer(),
                    car.getPower()
            );
            carsDTO.add(carDTO);
        }
        return new ResponseEntity<>(carsDTO, HttpStatus.OK);
    }

    public ResponseEntity<Void> removeCarById(String id) {
        if (!carDAO.existsById(id)) {
            throw new RuntimeException("Car not found");
        }
        carDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> removeCarsWithPowerLessThan(double value) {
        List<Car> cars = carDAO.findByPowerLessThan(value);
        if (cars.isEmpty()) {
            throw new RuntimeException("Cars not found");
        }
        for (Car car: cars) {
            carDAO.deleteById(car.getId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Void> addNewCar(Car car) {
        carDAO.save(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
