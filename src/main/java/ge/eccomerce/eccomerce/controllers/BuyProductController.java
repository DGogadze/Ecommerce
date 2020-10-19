package ge.eccomerce.eccomerce.controllers;

import ge.eccomerce.eccomerce.model.Product;
import ge.eccomerce.eccomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BuyProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/buyproduct")
    public String buyProduct(@RequestParam int count,@RequestParam long id){
        Product product = productRepository.findById(id);
        int activeCount = product.getCount();
        product.setCount(activeCount-=count);
        productRepository.save(product);
        return "redirect:/";
    }
}
