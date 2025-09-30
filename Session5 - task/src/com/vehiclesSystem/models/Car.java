package com.vehiclesSystem.models;
import lombok.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Setter
@Getter
@ToString
public class Car implements Vehicle {
    private int id;
    private String type;
    private String brand;
}
