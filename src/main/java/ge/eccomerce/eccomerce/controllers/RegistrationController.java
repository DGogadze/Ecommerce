package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import ge.eccomerce.eccomerce.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestBody User user){
        String userEmail = user.getUserEmail();
        String userPrivateId = user.getUserPrivateId();
        if (userRepository.findByUserEmail(userEmail)==null&&userRepository.findByUserPrivateId(userPrivateId)==null){
            userRegistrationService.userRegistration(user);
        } else {
            return "redirect:/registrationfailed";
        }

        return "redirect:/home";
    }

    @GetMapping("/registrationfailed")
    public String registrationFailed(){

        return "registrationfailed";
    }
}
