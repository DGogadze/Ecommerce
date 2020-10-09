package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivationController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/activation")
    public String activation(@RequestParam int token,@RequestParam String userEmail, Model model){
        User user = userRepository.findByUserEmail(userEmail);
        if (user.getActivationToken() == token){
            user.setActivated(true);
            userRepository.save(user);
        }
        return "activation";
    }
}
