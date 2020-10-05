package ge.eccomerce.eccomerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    public User() {
    }

    public User(String userEmail, String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int userPrivateIdNumber;

    private String userName;
    private String userPassword;
    private String userEmail;

    boolean activated = false;

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

    public int getUserPrivateIdNumber() {
        return userPrivateIdNumber;
    }

    public void setUserPrivateIdNumber(int userPrivateIdNumber) {
        this.userPrivateIdNumber = userPrivateIdNumber;
    }
}
