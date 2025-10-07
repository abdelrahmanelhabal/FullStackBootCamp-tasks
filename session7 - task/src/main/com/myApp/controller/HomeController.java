package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request , Model model)
    {
        int year = Integer.parseInt(request.getParameter("year"));
        int month = Integer.parseInt(request.getParameter("month"));
        int day = Integer.parseInt(request.getParameter("day"));

        LocalDate userDDB =  LocalDate.of(year, month, day);
        LocalDate now = LocalDate.now();

        Period period = Period.between(userDDB, now);

        model.addAttribute("year" , period.getYears());
        model.addAttribute("month" , period.getMonths());
        model.addAttribute("day" , period.getDays());

        return "resultPage";
    }
}


