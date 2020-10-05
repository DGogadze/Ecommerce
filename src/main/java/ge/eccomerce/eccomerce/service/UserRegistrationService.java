package ge.eccomerce.eccomerce.service;

import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public void userRegistration(String userEmail,String userName,String userPassword){
        User user = new User(userEmail,userName,bCryptPasswordEncoder.encode(userPassword));
        userRepository.save(user);
    }
}
