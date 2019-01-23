package model;

import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author {
    @Id
    private int id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
}
