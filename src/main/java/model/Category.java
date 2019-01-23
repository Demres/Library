package model;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    private int id;
    private String name;
}
