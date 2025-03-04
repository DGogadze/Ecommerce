package ge.ecommerce.service;

import ge.ecommerce.model.User;
import ge.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MailSenderService mailSenderService;

    public void userRegistration(User user){
        String userEmail = user.getUserEmail();
        String userName = user.getUserName();
        String userLastname = user.getUserLastname();
        mailSenderService.sendMail(userEmail,"Ec-commerce registration",
                "\t მოგესალმებით " + userName + " " + userLastname + "\n თქვენ დარეგისტრირდით" +
                        " ონლაინ მაღაზია Ec-commerce-ში.\n გაყევით ბმულს თქვენი მომხმარებლის აქტივაციისთვის." +
                        "\n http://www.localhost:8080/activation?userEmail=" +
                        userEmail + "&token=" + user.getActivationToken());
        userRepository.save(user);
    }

    public void userRegistration(String userEmail,
                                 String userName,
                                 String userLastname,
                                 String userPhoneNumber,
                                 String userBankAccountNumber){
        User user = new User(userPhoneNumber,userName,userLastname,userEmail,userBankAccountNumber);
        mailSenderService.sendMail(userEmail,"Ec-commerce registration",
                "\t მოგესალმებით " + userName + " " + userLastname + "\n თქვენ დარეგისტრირდით" +
                        " ონლაინ მაღაზია Ec-commerce-ში.\n გაყევით ბმულს თქვენი მომხმარებლის აქტივაციისთვის." +
                        "\n http://www.localhost:8080/activation?userEmail=" +
                        userEmail + "&token=" + user.getActivationToken());
        userRepository.save(user);
    }
}
