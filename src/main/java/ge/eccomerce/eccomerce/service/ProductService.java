package ge.eccomerce.eccomerce.service;

import ge.eccomerce.eccomerce.model.Product;
import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.ProductRepository;
import ge.eccomerce.eccomerce.repository.UserRepository;
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
