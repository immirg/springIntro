package org.example.task2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarDAO extends JpaRepository<Car, Integer> {
    @Query("select c from Car as c where c.power=:power")
    List<Car> findByPower(double power);

    @Query("select c from Car as c where c.producer=:producer")
    List<Car> findByProducer(String producer);
}
