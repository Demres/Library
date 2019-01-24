package model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="start_date", nullable = false)
    private Date startDate;
    @Column(name="end_date", nullable = false)
    private Date endDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReservationType type;
    @OneToMany
    private Set<BookCopy> bookCopies;
    @OneToOne
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ReservationType getType() {
        return type;
    }

    public void setType(ReservationType type) {
        this.type = type;
    }
}
