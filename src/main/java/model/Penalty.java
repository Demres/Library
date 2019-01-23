package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="penalties")
public class Penalty {
    @Id
    private int id;
    @Column(name="due_date")
    private Date dueDate;
    private double amount;
    private double interest;
}
