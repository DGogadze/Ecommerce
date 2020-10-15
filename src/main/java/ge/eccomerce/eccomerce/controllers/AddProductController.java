package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.model.Product;
import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import ge.eccomerce.eccomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddProductController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductService productService;

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepository.findByUserEmail(userDetails.getUsername());
        model.addAttribute("useremail",user.getUserEmail());
        return "addproduct";
    }
    @PostMapping("/addproduct")
    public String addProduct(@RequestParam String name,@RequestParam double cost,@RequestParam int count){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            User user = userRepository.findByUserEmail(userDetails.getUsername());
            productService.addNewProduct(user.getUserEmail(),name,cost,count);
        }
        return "redirect:/";
    }
}
