package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.model.Product;
import ge.eccomerce.eccomerce.repository.ProductRepository;
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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyProductController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    Product product;

    @PostMapping("/buyproduct")
    public String buyProduct(@RequestParam int count,@RequestParam long id){
        Product product = productRepository.findById(id);
        this.product=product;
        int activeCount = product.getCount();
        if (activeCount-count<0){
            return "redirect:/";
        }
        product.setCount(activeCount-=count);
        productRepository.save(product);
        return "redirect:/buyproductsuccessful";
    }
    @GetMapping("/buyproductsuccessful")
    public String successfull(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            model.addAttribute("useremail",userDetails.getUsername());
            model.addAttribute("boughtproduct",product.getName());
        }
        return "buyproductsuccessful";
    }
}
