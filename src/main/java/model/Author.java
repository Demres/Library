package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="authors")
public class Author {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="first_name", nullable = false)
    private String firstName;
    @Column(name="last_name", nullable = false)
    private String lastName;
    @ManyToMany
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
