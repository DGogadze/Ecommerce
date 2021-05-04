package ge.ecommerce.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    public User() {

    }

    public User(String userPrivateId,
                String userName,
                String userLastname,
                String userEmail,
                String userBankAccountNumber) {
        this.userPrivateId = userPrivateId;
        this.userName = userName;
        this.userLastname = userLastname;
        this.userEmail = userEmail;
        this.userBankAccountNumber = userBankAccountNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private Set<Product> products;

    private String userPrivateId;
    private String userName;
    private String userLastname;
    private String userPassword;
    private String userEmail;
    private String userBankAccountNumber;

    private boolean activated = false;

    private final int activationToken = (int) (Math.random()*10000);
    private final int changePasswordToken = (int) (Math.random()*10000);

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

    public String getUserBankAccountNumber() {
        return userBankAccountNumber;
    }

    public void setUserBankAccountNumber(String userBankAccountNumber) {
        this.userBankAccountNumber = userBankAccountNumber;
    }

    public String getUserPrivateId() {
        return userPrivateId;
    }

    public void setUserPrivateId(String userPrivateId) {
        this.userPrivateId = userPrivateId;
    }

    public int getChangePasswordToken() {
        return changePasswordToken;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProducts(Product product){
        this.products.add(product);
    }
}
