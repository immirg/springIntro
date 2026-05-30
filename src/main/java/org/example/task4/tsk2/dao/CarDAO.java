package org.example.task4.tsk2.dao;

import org.example.task4.tsk2.entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CarDAO extends MongoRepository <Car, String> {
    List<Car> findByPower(double power);

    List<Car> findByProducer(String producer);

    List<Car> findByPowerLessThan(double power);
}
