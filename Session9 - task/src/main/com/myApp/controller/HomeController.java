package main.com.myApp.controller;

import main.model.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;


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
    public String processForm(@Valid @ModelAttribute("userModel") UserModel userModel , BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors())
            return "formPage";
        model.addAttribute("result", userModel);
        return "resultPage";
    }
}


