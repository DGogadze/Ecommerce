package ge.ecommerce.repository;

import ge.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Product findById(long id);
    Product findByName(String name);
}
