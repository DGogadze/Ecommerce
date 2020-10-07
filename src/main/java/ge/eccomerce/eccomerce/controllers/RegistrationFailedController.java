package ge.eccomerce.eccomerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationFailedController {
    @GetMapping("/registrationfailed")
    public String registrationFailed(@ModelAttribute("userEmail") String userEmail,
                                     @ModelAttribute("userPrivateId") String userPrivateId,
                                     Model model){

        return "registrationfailed";
    }
}
