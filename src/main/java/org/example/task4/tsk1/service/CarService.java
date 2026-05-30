package org.example.task4.tsk1.service;

import lombok.RequiredArgsConstructor;
import org.example.task4.tsk1.dao.CarDAO;
import org.example.task4.tsk1.dto.CarDTO;
import org.example.task4.tsk1.entity.Car;
import org.example.task4.tsk1.enums.Producer;
import org.example.task4.tsk1.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarDAO carDAO;
    private final MailService mailService;
    private final User user;

    public ResponseEntity<List<CarDTO>> findAllCars() {
        List<CarDTO> cars = carDAO.findAll().stream().map(car -> new CarDTO(
                car.getId(),
                car.getModel(),
                car.getProducer(),
                car.getPower(),
                car.getImageName())).toList();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    public ResponseEntity<CarDTO> findCarById(Integer id) {
        Car car = carDAO.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        CarDTO carDTO = new CarDTO(
                car.getId(),
                car.getModel(),
                car.getProducer(),
                car.getPower(),
                car.getImageName()
        );
        return new ResponseEntity<>(carDTO, HttpStatus.OK);
    }

    public ResponseEntity<Void> removeCarById(Integer id) {
        if (!carDAO.existsById(id)) {
            throw new RuntimeException("Car not found");
        }
        CarDTO carDTO = findCarById(id).getBody();
        carDAO.deleteById(id);
        mailService.send(user.getEmail(), "removed", carDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<List<CarDTO>> findCarsByPower(Double power) {
        List<Car> cars = carDAO.findCarsByPower(power);
        if (cars.isEmpty()) {
            throw new RuntimeException("Cars not found");
        }
        List<CarDTO> carsDTO = new ArrayList<>();
        for (Car car: cars) {
            CarDTO carDTO = new CarDTO(
                    car.getId(),
                    car.getModel(),
                    car.getProducer(),
                    car.getPower(),
                    car.getImageName()
            );
            carsDTO.add(carDTO);
        }
        return new ResponseEntity<>(carsDTO, HttpStatus.OK);
    }

    public ResponseEntity<List<CarDTO>> findCarsByProducer(Producer producer) {
        List<Car> cars = carDAO.findCarsByProducer(producer);
        if (cars.isEmpty()) {
            throw new RuntimeException("Cars not found");
        }
        List<CarDTO> carsDTO = new ArrayList<>();
        for (Car car: cars) {
            CarDTO carDTO = new CarDTO(
                    car.getId(),
                    car.getModel(),
                    car.getProducer(),
                    car.getPower(),
                    car.getImageName()
            );
            carsDTO.add(carDTO);
        }
        return new ResponseEntity<>(carsDTO, HttpStatus.OK);
    }

    public ResponseEntity<Void> addNewCar(Car car) {
        carDAO.save(car);
        CarDTO carDTO = new CarDTO(car.getId(), car.getModel(), car.getProducer(), car.getPower(), car.getImageName());
        mailService.send(user.getEmail(), "created", carDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
