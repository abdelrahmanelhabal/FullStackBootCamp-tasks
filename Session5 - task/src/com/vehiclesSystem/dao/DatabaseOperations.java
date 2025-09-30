package com.vehiclesSystem.dao;

import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Vehicle;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@Scope("singleton")
@Repository
@Setter
@Getter
@ToString
public class DatabaseOperations {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    private Connection connection;
    public  DatabaseOperations(){}

    @PostConstruct
    public void connectToDatabase() {
        try{
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(url,username,password);
            System.out.println("Database connection established");
        }
        catch (SQLException e){
            throw new RuntimeException("Failed to create DB connection", e);
        }
    }

    @PreDestroy
    public void disconnectFromDatabase() {
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
                System.out.println("Database connection closed");
            }
        }catch (SQLException e){
            throw new RuntimeException("Failed to close DB connection", e);
        }
    }

    public void save(Vehicle vehicle) {
        String QUERY = "INSERT INTO Vehicles (type,brand) VALUES (?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setString(1,vehicle.getType());
            preparedStatement.setString(2,vehicle.getBrand());
            preparedStatement.executeUpdate();
            System.out.println("The data is added to the database");
        }catch (SQLException e){
            throw new RuntimeException("Failed to add data to DB", e);
        }
    }

    public void update(Vehicle vehicle){
        String QUERY = "UPDATE Vehicles SET type=? , brand=? WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setString(1,vehicle.getType());
            preparedStatement.setString(2,vehicle.getBrand());
            preparedStatement.setInt(3,vehicle.getId());
            preparedStatement.executeUpdate();
            System.out.println("The data is updated on the database");
        }catch (SQLException e){
            throw new RuntimeException("Failed to update data on DB", e);
        }
    }

    public void delete(int id){
        String QUERY = "DELETE FROM Vehicles WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            System.out.println("The data is delete from the database");
        }catch (SQLException e){
            throw new RuntimeException("Failed to delete data from DB", e);
        }
    }

    public Vehicle findById(int id){
        String QUERY = "SELECT * FROM Vehicles WHERE id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, id);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                Car vehicle = new Car();
                vehicle.setId(res.getInt("id"));
                vehicle.setBrand(res.getString("brand"));
                vehicle.setType(res.getString("type"));
                return vehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Vehicle> findAll(){
        List<Vehicle> vehicles = new LinkedList<>();
        String QUERY = "SELECT * FROM Vehicles";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
        ResultSet res = preparedStatement.executeQuery();
        while (res.next()) {
            Car vehicle = new Car();
            vehicle.setId(res.getInt("id"));
            vehicle.setBrand(res.getString("brand"));
            vehicle.setType(res.getString("type"));
            vehicles.add(vehicle);
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return vehicles;
    }
}
