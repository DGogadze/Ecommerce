package ge.eccomerce.eccomerce.controllers;

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
    public String registration(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String userEmail,
                               @RequestParam String userName,
                               @RequestParam String userLastname,
                               @RequestParam String userBankAccountNumber,
                               @RequestParam String userPhoneNumber,
                               RedirectAttributes redirectAttributes,
                               Model model){
        if (userRepository.findByUserEmail(userEmail)==null&&userRepository.findByUserPhoneNumber(userPhoneNumber)==null){
            userRegistrationService.userRegistration(userEmail,userName,userLastname,userPhoneNumber,userBankAccountNumber);
        } else {
            redirectAttributes.addFlashAttribute("userEmail",userEmail);
            redirectAttributes.addFlashAttribute("userPhoneNumber",userPhoneNumber);
            return "redirect:/registrationfailed";
        }

        return "redirect:/home";
    }

    @GetMapping("/registrationfailed")
    public String registrationFailed(Model model){

        return "registrationfailed";
    }
}
