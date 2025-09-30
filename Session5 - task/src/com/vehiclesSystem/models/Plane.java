package com.vehiclesSystem.models;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
@Setter
@Getter
@ToString
public class Plane implements Vehicle {
    private int id;
    private String type;
    private String brand;
}
