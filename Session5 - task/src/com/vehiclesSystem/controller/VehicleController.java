package com.vehiclesSystem.controller;

import com.vehiclesSystem.models.Vehicle;

import java.util.List;

public interface VehicleController {
    void save(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(int id);
    List<Vehicle> getAll();
    Vehicle findById(int id);
}
