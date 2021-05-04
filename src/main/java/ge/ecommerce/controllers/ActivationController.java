package ge.ecommerce.controllers;

import ge.ecommerce.model.User;
import ge.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ActivationController {
    @Autowired
    UserRepository userRepository;

    User user;

    @GetMapping("/activation")
    public String activation(@RequestParam int token,@RequestParam String userEmail, Model model){
        User user = userRepository.findByUserEmail(userEmail);
        if (user.isActivated())
            return "redirect:/accountactivated";
        if (user.getActivationToken() == token){
            user.setActivated(true);
            this.user = user;
        }
        return "activation";
    }
    @PostMapping("/activation")
    public String activation(@RequestParam String password,Model model){
        this.user.setUserPassword(password);
        userRepository.save(user);
        return "redirect:/activationsuccessful";
    }
    @GetMapping("/activationsuccessful")
    public String activationSuccessfull(Model model){
        return "activationsuccessful";
    }
    @GetMapping("/accountactivated")
    public String accountActivated(Model model){
        return "accountactivated";
    }
}
