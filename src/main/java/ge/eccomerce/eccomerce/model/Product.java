package ge.eccomerce.eccomerce.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    public Product() {

    }

    @Id
    long id;

    private String name;

    double cost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
