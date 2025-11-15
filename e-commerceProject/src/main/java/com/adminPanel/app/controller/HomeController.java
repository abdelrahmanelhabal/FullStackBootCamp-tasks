package com.adminPanel.app.controller;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    @RequestMapping("/add")
    public String addProduct(Model model) {
        ProductDetails productDetails = new  ProductDetails();
        model.addAttribute("productDetailsModel",productDetails );
        return "add";
    }


    @RequestMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "list";
    }

    @RequestMapping("/edit/{id}")
    public String addProduct(@PathVariable int id,Model model) {
        ProductDetails productDetails = productService.get(id).getProductDetails();
        System.out.println(productDetails);
        model.addAttribute("productDetailsModel", productDetails);
        return "add";
    }
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("productDetailsModel") ProductDetails productDetails , BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add";
        }
        if (productDetails.getId() == 0){
            productService.create(productDetails);
        }
        else{
            productService.update(productDetails);
        }
        return "redirect:/";
    }


    @RequestMapping("/showDetails/{id}")
    public String showDetails(@PathVariable int id,Model model) {
        ProductDetails productDetails = productService.get(id).getProductDetails();
        if (productDetails == null) {
            return "redirect:/";
        }
        model.addAttribute("product", productDetails);
        return "show";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/";
    }
}
