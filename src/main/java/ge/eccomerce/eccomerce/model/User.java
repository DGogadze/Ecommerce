package ge.eccomerce.eccomerce.model;

import javax.persistence.*;

@Entity
public class User {
    public User() {
    }

    public User(String userPhoneNumber,
                String userName,
                String userLastname,
                String userEmail,
                String userBankAccountNumber) {
        this.userPhoneNumber = userPhoneNumber;
        this.userName = userName;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userBankAccountNumber = userBankAccountNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userPhoneNumber;
    private String userName;
    private String userLastname;
    private String userPassword;
    private String userEmail;
    private String userBankAccountNumber;

    private boolean activated = false;

    private final int activationToken = (int) (Math.random()*10000);

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public int getActivationToken() {
        return activationToken;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserBankAccountNumber() {
        return userBankAccountNumber;
    }

    public void setUserBankAccountNumber(String userBankAccountNumber) {
        this.userBankAccountNumber = userBankAccountNumber;
    }
}
