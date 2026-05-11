package org.example.task1;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
@Data
@Configuration
public class BeanConfig {
    private final List<Car> cars = new ArrayList<>();
    @Bean
    public Car car1() {
        Car car = new Car(1001L,"A3", "KIA", 200);
        cars.add(car);
        return car;
    }
    @Bean
    public Car car2() {
        Car car = new Car(1002L, "Q10", "Audi", 220);
        cars.add(car);
        return car;
    }
    @Bean
    public Car car3() {
        Car car = new Car(1003L,"Q7", "Mazda", 210);
        cars.add(car);
        return car;
    }
}
