package main.model;

import main.validation.FieldMatch;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class UserModel {
    @NotNull(message = "this field cannot empty or null")
    @Size(min = 1 , message = "this field cannot empty or null")
    private String username;

    @NotNull(message = "this field cannot empty or null")
    @Size(min = 1 , message = "this field cannot empty or null")
    private String password;

    private String confirmPassword;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z.-]+\\.[A-Za-z]{2,}$" , message = "please enter a valid email address")
    private  String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
