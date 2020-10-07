package ge.eccomerce.eccomerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home(Model model){
        return "index";
    }
    @GetMapping("/home")
    public String index(Model model){
        return "index";
    }
}
