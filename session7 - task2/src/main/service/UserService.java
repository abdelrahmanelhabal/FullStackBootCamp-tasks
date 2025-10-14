package main.service;

import main.dao.UserDao;
import main.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    @Autowired
    UserDao userDao ;
    public void createUser(String firstName, String lastName, String email, LocalDate birthDate, String city) {
        if (firstName == null || firstName.isEmpty() ||
                lastName == null || lastName.isEmpty() ||
                email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Name and email cannot be empty.");
        }

        UserModel user = new UserModel(firstName, lastName, email, birthDate, city);
        userDao.save(user);
    }
}
