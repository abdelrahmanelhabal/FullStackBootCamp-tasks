package com.vehiclesSystem.models;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Getter
@Setter
@ToString
public class Bike implements Vehicle {
    private int id;
    private String type;
    private String brand;



}
