package main.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
@Setter
@Getter
public class UserModel {
    int id ;
    String  firstName ;
    String lastName ;
    String email ;
    LocalDate birthDate ;
    String city ;
  public UserModel(String firstName, String lastName, String email, LocalDate birthDate, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.city = city;
    }
}
