package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="publishers")
public class Publisher {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false)
    private String name;
    private String location;
    @OneToMany
    private Set<Book> books;
}
