package com.vehiclesSystem.controller;
import com.vehiclesSystem.dao.DatabaseOperations;
import com.vehiclesSystem.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarController implements VehicleController {
    DatabaseOperations dbOps;
    @Autowired
    public CarController(DatabaseOperations dbOps) {
        this.dbOps = dbOps;
    }

    @Override
    public void save(Vehicle vehicle) {
        dbOps.save(vehicle);
    }

    @Override
    public void update(Vehicle vehicle) {
        dbOps.update(vehicle);
    }

    @Override
    public void delete(int id) {
        dbOps.delete(id);
    }

    @Override
    public List<Vehicle> getAll() {
       return dbOps.findAll();
    }

    @Override
    public Vehicle findById(int id) {
      return   dbOps.findById(id);
    }

}
