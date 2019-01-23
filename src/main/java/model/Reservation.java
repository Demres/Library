package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="reservations")
public class Reservation {
    @Id
    private int id;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;
    @Enumerated(EnumType.STRING)
    private ReservationType type;
}
