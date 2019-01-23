package model;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import java.sql.Date;
import java.time.Year;

@Entity
@Table(name = "books")
public class Book {
    @NaturalId
    @ISBN
    private String ISBN;
    private String title;
    private String description;
    private int edition;
    private int pages;
    @Column(
            name="publication_year",
            columnDefinition = "smallint"
    )
    @Convert(
            converter = YearAttributeConverter.class
    )
    private Year publicationYear;
}
