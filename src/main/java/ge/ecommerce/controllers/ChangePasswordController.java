package ge.ecommerce.controllers;

import ge.ecommerce.model.User;
import ge.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChangePasswordController {
    @Autowired
    UserRepository userRepository;

    private String userPrivateId;
    private int token;

    @GetMapping("/changepassword")
    public String recovery(@RequestParam int token, @RequestParam String userPrivateId){
        this.token = token;
        this.userPrivateId = userPrivateId;
        return "changepassword";
    }
    @PostMapping("/changepassword")
    public String recovery(@RequestParam String newPassword){
        User user = userRepository.findByUserPrivateId(userPrivateId);
        if (user.getChangePasswordToken()==token){
            user.setUserPassword(newPassword);
            userRepository.save(user);
        }
        return "redirect:/login";
    }
}
