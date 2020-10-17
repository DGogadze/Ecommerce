package ge.eccomerce.eccomerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuyProductController {
    @PostMapping("/buyproduct")
    public String buyProduct(int count){
        return "redirect:/home";
    }
}
