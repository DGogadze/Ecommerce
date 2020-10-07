package ge.eccomerce.eccomerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationFailedController {
    @GetMapping("/registrationfailed")
    public String registrationFailed(Model model){

        return "registrationfailed";
    }
}
