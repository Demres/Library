package model;

import javax.persistence.*;

@Entity
@Table(name="languages")
public class Language {
    @Id
    private int id;
    private String name;
}
