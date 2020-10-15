package ge.eccomerce.eccomerce.service;

import ge.eccomerce.eccomerce.model.User;
import ge.eccomerce.eccomerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoveryMailService {
    @Autowired
    MailSenderService mailSenderService;
    @Autowired
    UserRepository userRepository;

    public void changePassword(String emailTo,String subject){
        User user = userRepository.findByUserEmail(emailTo);
        mailSenderService.sendMail(emailTo,subject,"მოგესალმებით," + user.getUserName() + " " + "" +
                user.getUserLastname() + "\n" +
                "გთხოვთ გადახვიდეთ ბმულზე ახალი პაროლის დასაყენებლად.\n" +
                "http://www.localhost:8080/changepassword?token="+user.getChangePasswordToken()+"&userPrivateId="+
                user.getUserPrivateId());
    }
}
