package ge.eccomerce.eccomerce.service;

import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    UserRepository userRepository;

    public void userRegistration(String userEmail,String userName,String userLastname,int userPrivateId){
        User user = new User(userPrivateId,userName,userLastname,userEmail);
        userRepository.save(user);
    }
}
