package model;

import javax.persistence.*;
import java.util.Set;

public class BookCopy {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(nullable = false)
    private int status;
    @ManyToOne
    private Book book;
    @ManyToMany
    private Set<Borrow> borrows;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
