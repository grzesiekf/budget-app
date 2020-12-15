package model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OUTGO")
public class Outgo {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private LocalDate date;
    private double value;

    @ManyToOne
    private User owner;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Outgo{" +
                "id=" + id +
                ", name= + " + name +
                ", date= " + date +
                ", value='" + value +
                ", owner=" + owner.getName() +
                '}';
    }

}
