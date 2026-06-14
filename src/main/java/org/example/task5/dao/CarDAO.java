package org.example.task5.dao;

import org.example.task5.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarDAO extends JpaRepository<Car, Integer> {

    List<Car> findByPower(double power);

    List<Car> findByProducer(String producer);

    List<Car> findByPowerLessThan(double power);
}
