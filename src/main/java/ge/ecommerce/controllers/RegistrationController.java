package ge.ecommerce.controllers;

import ge.ecommerce.model.User;
import ge.ecommerce.repository.UserRepository;
import ge.ecommerce.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {
    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestBody User user) {
        String userEmail = user.getUserEmail();
        String userPrivateId = user.getUserPrivateId();
        if (userRepository.findByUserEmail(userEmail) == null && userRepository.findByUserPrivateId(userPrivateId) == null) {
            userRegistrationService.userRegistration(user);
        } else {
            return "redirect:/registrationfailed";
        }

        return "redirect:/home";
    }

    @GetMapping("/registrationfailed")
    public String registrationFailed() {

        return "registrationfailed";
    }
}
