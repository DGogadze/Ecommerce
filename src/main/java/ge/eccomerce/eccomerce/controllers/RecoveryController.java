package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import ge.eccomerce.eccomerce.service.RecoveryMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RecoveryController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RecoveryMailService recoveryMailService;

    @GetMapping("/recovery")
    public String recovery(){
        return "recovery";
    }
    @PostMapping("/recovery")
    public String recovery(@RequestParam String userPrivateId){
        User user = userRepository.findByUserPrivateId(userPrivateId);
        recoveryMailService.changePassword(user.getUserEmail(),"Ec-commerce recivery");
        return "redirect:/home";
    }
}
