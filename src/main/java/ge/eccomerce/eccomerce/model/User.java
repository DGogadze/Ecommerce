package ge.eccomerce.eccomerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    public User() {
    }

    public User(String userPrivateIdNumber,
                String userName,
                String userLastname,
                String userEmail) {
        this.userPrivateIdNumber = userPrivateIdNumber;
        this.userName = userName;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String userPrivateIdNumber;

    private String userName,userLastname;
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
}
