package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/profile")
    public String profile(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userRepository.findByUserEmail(userDetails.getUsername());

            model.addAttribute("username",user.getUserName() + " " + user.getUserLastname());
            model.addAttribute("useremail",user.getUserEmail());
            model.addAttribute("products",user.getProducts());
            model.addAttribute("bankaccount",user.getUserBankAccountNumber());
            model.addAttribute("userPrivateId",user.getUserPrivateId());
        }
        return "profile";
    }

    @PostMapping("/profile")
    public String profile(){
        return "profile";
    }
}
