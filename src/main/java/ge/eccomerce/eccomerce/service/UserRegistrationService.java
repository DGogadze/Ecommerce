package ge.eccomerce.eccomerce.service;

import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSenderService mailSenderService;

    public void userRegistration(String userEmail,String userName,String userLastname,int userPrivateId){
        User user = new User(userPrivateId,userName,userLastname,userEmail);
        mailSenderService.sendMail(userEmail,"Ec-commerce registration",
                "\t მოგესალმებით " + userName + " " + userLastname + "\n თქვენ დარეგისტრირდით" +
                        " ონლაინ მაღაზია Ec-commerce-ში.\n გაყევით ბმულს თქვენი მომხმარებლის აქტივაციისთვის." +
                        "\n SHORTLINK HERE");
        userRepository.save(user);
    }
}
