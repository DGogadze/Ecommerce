package ge.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorizationController {
    @GetMapping("/login")
    public String login(){
        return "authorization";
    }
    @PostMapping("/login")
    public String login(Model model){
        return "authorization";
    }
}