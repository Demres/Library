package model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name="borrows")
public class Borrow {
    @Id
    private int id;
    /*
    When dealing with dates, it’s a good idea to set a specific time zone for the JDBC driver.
    For our example, we’ll set it up on a per-session basis:
        session = HibernateUtil.getSessionFactory().withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("UTC"))
                     .openSession();
     Another way would be to set up the hibernate.jdbc.time_zone property in Hibernate properties file that is used to construct the session factory.
     This way we could specify the timezone once for the entire application.
 */
    @Column(name="borrowed_on")
    private Date borrowedOn;
    @Column(name="due_date")
    private Date dueDate;
    private Date returned;
}
