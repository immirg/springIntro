package org.example.task4.tsk1.model;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class User {
    private final String name = "admin";
    private final String email = "immirg@gmail.com";
}
