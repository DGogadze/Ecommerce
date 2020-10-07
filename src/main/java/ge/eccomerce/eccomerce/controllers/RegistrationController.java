package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.repository.UserRepository;
import ge.eccomerce.eccomerce.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String registration(@RequestParam String userEmail,
                               @RequestParam String userName,
                               @RequestParam String userLastname,
                               @RequestParam String userPrivateId,
                               Model model){
        if (userRepository.findByUserEmail(userEmail)==null&&userRepository.findByUserPrivateIdNumber(Integer.parseInt(userPrivateId))==null){
            userRegistrationService.userRegistration(userEmail,userName,userLastname,Integer.parseInt(userPrivateId));
        } else {
            /** Need @ModelAttribute */

            return "redirect:/registrationfailed";
        }

        return "redirect:/home";
    }
}
