package ge.ecommerce.service;

import ge.ecommerce.model.Product;
import ge.ecommerce.model.User;
import ge.ecommerce.repository.ProductRepository;
import ge.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public void addNewProduct(String username,String name,double cost,int count){
        User user = userRepository.findByUserEmail(username);
        Product product = new Product(name,cost,count);
        productRepository.save(product);
        user.addProducts(product);
        userRepository.save(user);
    }
}
