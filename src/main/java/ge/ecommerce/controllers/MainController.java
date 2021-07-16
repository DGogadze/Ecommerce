package ge.ecommerce.controllers;

import ge.ecommerce.model.Product;
import ge.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("useremail",userDetails.getUsername());
            return "indexUser";
        } else
            return "index";
    }

    @GetMapping("/home")
    public String index(Model model){
        return "index";
    }
}
