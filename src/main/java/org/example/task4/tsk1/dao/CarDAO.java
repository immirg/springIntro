package org.example.task4.tsk1.dao;

import org.example.task4.tsk1.entity.Car;
import org.example.task4.tsk1.enums.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarDAO extends JpaRepository<Car, Integer> {
    @Query("select c from Car as c where c.power=:power")
    List<Car> findCarsByPower(double power);

    @Query("select c from Car as c where c.producer=:producer")
    List<Car> findCarsByProducer(Producer producer);
}
