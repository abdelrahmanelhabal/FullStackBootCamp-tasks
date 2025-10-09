package main.com.myApp.controller;

import main.dao.UserDao;
import main.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class HomeController
{
    @Autowired
    UserDao userDao ;
    @Autowired
    UserModel userModel;

    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request , Model model)
    {
        String firstName = request.getParameter("first name");
        String lastName = request.getParameter("last name");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String City = request.getParameter("city");
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(date);
        } catch (Exception e) {
            System.out.println("Invalid date format: " + date);
        }

        userModel.setFirstName(firstName);
        userModel.setLastName(lastName);
        userModel.setEmail(email);
        userModel.setBirthDate(birthDate);
        userModel.setCity(City);

        userDao.save(userModel);

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        model.addAttribute("birthDate", birthDate);
        model.addAttribute("City", City);

        return "resultPage";
    }
}


