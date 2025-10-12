package main.com.myApp.controller;

import main.model.UserModel;
import main.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class HomeController
{

    UserService userService;

    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request , Model model)
    {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String City = request.getParameter("city");
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(date);
        } catch (Exception e) {
            System.out.println("Invalid date format: " + date);
        }

        userService.createUser(firstName, lastName, email, birthDate, City);
        UserModel user = new UserModel(firstName, lastName, email, birthDate, City);
        model.addAttribute("user", user);

        return "resultPage";
    }
}


