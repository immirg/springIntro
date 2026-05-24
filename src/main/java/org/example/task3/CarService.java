package org.example.task3;

import lombok.RequiredArgsConstructor;
import org.example.task3.dao.CarDAO;
import org.example.task3.dto.CarDTO;
import org.example.task3.enums.Producer;
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
                car.getPower())).toList();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    public ResponseEntity<CarDTO> findCarById(Integer id) {
        Car car = carDAO.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        CarDTO carDTO = new CarDTO(
                car.getId(),
                car.getModel(),
                car.getProducer(),
                car.getPower()
        );
        return new ResponseEntity<>(carDTO, HttpStatus.OK);
    }

    public ResponseEntity<Void> removeCarById(Integer id) {
        if (!carDAO.existsById(id)) {
            throw new RuntimeException("Car not found");
        }
        carDAO.deleteById(id);
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
                    car.getPower()
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
                    car.getPower()
            );
            carsDTO.add(carDTO);
        }
        return new ResponseEntity<>(carsDTO, HttpStatus.OK);
    }

    public ResponseEntity<Void> addNewCar(Car car) {
        carDAO.save(car);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
