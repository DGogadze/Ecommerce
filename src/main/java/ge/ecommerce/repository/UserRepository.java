package ge.ecommerce.repository;

import ge.ecommerce.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
    User findById(long id);
    User findByUserEmail(String userEmail);
    User findByUserPrivateId(String userPrivateId);
}
