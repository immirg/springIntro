package org.example.task1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {
    private final BeanConfig beanConfig;
    public List<Car> findAllCars() {
        return beanConfig.getCars();
    }
    public Optional<Car> findById(Long id) {
        return beanConfig.getCars().stream().filter(car -> car.getId().equals(id)).findFirst();
    }
    public List<Car> findByPower(double searchPower) {
        return beanConfig.getCars().stream().filter(car -> searchPower == car.getPower()).toList();
    }
    public List<Car> findByProducer(String producer) {
        return beanConfig.getCars().stream().filter(car -> producer.equals(car.getProducer())).toList();
    }
    public String removeById(Long id) {
        boolean isRemoved =  beanConfig.getCars().removeIf(car -> car.getId().equals(id));
        if (isRemoved) {
            return "car with id " + id + " was removed";
        }
        else {
            return "car with id " + id + " wasn't found";
        }
    }
    public String newCar(Car car) {
        Long newId = beanConfig.getCars().stream().max(Comparator.comparing(Car::getId)).get().getId() + 1;
        if (!car.getModel().isBlank() && !car.getProducer().isBlank() && car.getPower() > 0) {
            car.setId(newId);
            beanConfig.getCars().add(car);
            return "new car was created";
        } else {
            return "car wasn't created, there is one or more mistake in parameters";
        }
    }
}
