package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.repository.UserRepository;
import ge.eccomerce.eccomerce.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    UserRegistrationService userRegistrationService;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String userEmail,@RequestParam String userName,
                               @RequestParam String userPassword,Model model){
        if (userRepository.findByUserName(userName)==null&&userRepository.findByUserEmail(userEmail)==null){
            userRegistrationService.userRegistration(userEmail,userName,userPassword);

            return "redirect:/home";
        }
        return "redirect:/home";
    }
}
