package main.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
@Component
@Setter
@Getter
public class UserModel {
    int id ;
    String  firstName ;
    String lastName ;
    String email ;
    LocalDate birthDate ;
    String city ;
}
