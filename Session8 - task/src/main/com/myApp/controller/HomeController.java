package main.com.myApp.controller;

import main.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage(Model model)
    {
        model.addAttribute("userModel", new UserModel());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("userModel") UserModel userModel, Model model)
    {
        model.addAttribute("result", userModel);
        return "resultPage";
    }
}


