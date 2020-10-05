package ge.eccomerce.eccomerce.repository;

import ge.eccomerce.eccomerce.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{
    User findById(long id);
    User findByUserName(String userName);
    User findByUserEmail(String userEmail);
}
