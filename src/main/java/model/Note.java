package model;

import javax.persistence.*;

@Entity
@Table(name = "NOTES")
public class Note {

    @Id
    @GeneratedValue
    private int id;

    private String value;

    @ManyToOne
    private User owner;

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
        owner.addNote(this);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", owner=" + owner.getName() +
                '}';
    }
}
