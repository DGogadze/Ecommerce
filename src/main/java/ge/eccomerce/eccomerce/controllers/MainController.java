package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.model.Product;
import ge.eccomerce.eccomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model){
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products",products);
        return "index";
    }
    @GetMapping("/home")
    public String index(Model model){
        return "index";
    }
}
