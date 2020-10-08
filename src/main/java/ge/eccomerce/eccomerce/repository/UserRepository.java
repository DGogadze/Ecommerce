package ge.eccomerce.eccomerce.repository;

import ge.eccomerce.eccomerce.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
    User findById(long id);
    User findByUserEmail(String userEmail);
    User findByUserPrivateIdNumber(String userPrivateIdNumber);
}
