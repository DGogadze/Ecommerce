package ge.ecommerce.model;

import org.springframework.context.annotation.Primary;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    public Product() {

    }

    public Product(String name, double cost, int count) {
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String name;

    private double cost;
    
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
