package org.example.task2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarDAO carDAO;

    public List<Car> findAllCars() {
        return carDAO.findAll();
    }
    public Optional<Car> findById(int id) {
        return carDAO.findById(id);
    }
    public List<Car> findByPower(double power) {
        return carDAO.findByPower(power);
    }
    public List<Car> findByProducer(String producer) {
        return carDAO.findByProducer(producer);
    }
    public List<Car> removeById(int id) {
        carDAO.deleteById(id);
        return carDAO.findAll();
    }
    public List<Car> newCar(Car car) {
        carDAO.save(car);
        return carDAO.findAll();
    }
}
