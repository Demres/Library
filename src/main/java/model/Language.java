package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false)
    private String name;
    @OneToMany
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
