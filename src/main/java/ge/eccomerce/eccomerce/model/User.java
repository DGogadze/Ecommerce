package ge.eccomerce.eccomerce.model;

import javax.persistence.*;

@Entity
public class User {
    public User() {
    }

    public User(String userPrivateIdNumber,
                String userName,
                String userLastname,
                String userEmail,
                String userPassword) {
        this.userPrivateIdNumber = userPrivateIdNumber;
        this.userName = userName;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userPrivateIdNumber;

    private String userName,userLastname;
    private String userPassword;
    private String userEmail;

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

    public String getUserPrivateIdNumber() {
        return userPrivateIdNumber;
    }

    public void setUserPrivateIdNumber(String userPrivateIdNumber) {
        this.userPrivateIdNumber = userPrivateIdNumber;
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
}
