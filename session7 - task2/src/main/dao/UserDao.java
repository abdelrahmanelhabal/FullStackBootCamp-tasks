package main.dao;

import main.model.UserModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class UserDao {
    @Value("${db.url}")
    String url ;
    @Value("${db.username}")
    String username ;
    @Value("${db.password}")
    String password ;

    Connection connection;
    UserDao(){}
    @PostConstruct
   public void dbConnection(){

        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        try{
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established");
        }catch(Exception e){
            throw new RuntimeException("Failed to create DB connection",e);
        }
    }


    public void save(UserModel user){
        String QUERY = "INSERT INTO User_inf (firstName,LastName,email,birth_date,city) VALUES (?,?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getLastName());
            preparedStatement.setString(3,user.getEmail());
            preparedStatement.setDate(4, java.sql.Date.valueOf(user.getBirthDate()));
            preparedStatement.setString(5,user.getCity());
            preparedStatement.executeUpdate();
            System.out.println("User inserted successfully");
        }catch(Exception e){
            throw new RuntimeException("Failed to save user",e);
        }
    }
}
