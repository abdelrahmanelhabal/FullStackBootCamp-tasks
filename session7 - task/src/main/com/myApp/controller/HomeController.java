package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.ChronoUnit;

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
        //getting parameters from request
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        //processing the data that received from the request
        int yearsDifference = LocalDate.now().getYear() -  Integer.parseInt(year);
        int monthsDifference = LocalDate.now().getMonthValue() -  Integer.parseInt(month);
        int daysDifference = LocalDate.now().getDayOfMonth() -  Integer.parseInt(day);

        //adding data to the model
        model.addAttribute("year" , yearsDifference);
        model.addAttribute("month" , monthsDifference);
        model.addAttribute("day" , daysDifference);

        //return the view with model
        return "resultPage";
    }
}
