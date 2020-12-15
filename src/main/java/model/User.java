package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users")
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String password;

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Outgo> outgos = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {return password;}

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) { this.password = password;}

    public List<Outgo> getOutgos() {
        return new ArrayList<>(outgos);
    }

    public void addNote(Outgo outgo) {
        this.outgos.add(outgo);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name=" + name + ", password="+ password +'\'' +
            //   ", outgos=" + outgos +
                '}';
    }
}
