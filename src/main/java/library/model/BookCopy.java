package library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="BOOK_COPY")
public class BookCopy {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private int status;
    @ManyToOne
    private Book book;
    @ManyToMany
    private Set<Borrow> borrows;
    @ManyToMany
    private Set<Reservation> reservations;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Set<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(Set<Borrow> borrows) {
        this.borrows = borrows;
    }
}
