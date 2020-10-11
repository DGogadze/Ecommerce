package ge.eccomerce.eccomerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationController {
    @GetMapping("/login")
    public String login(Model model){
        return "authorization";
    }
    @PostMapping("/login")
    public String login(@RequestParam String userEmail,
                        @RequestParam String userPassword,
                        Model model){
        return "redirect:/profile";
    }
}