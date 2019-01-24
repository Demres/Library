package model;

import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Date;
import java.time.Year;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @NaturalId
    @ISBN
    private String ISBN;
    @Column(nullable = false)
    private String title;
    private String description;
    @Min(1)
    private int edition;
    @Min(1)
    private int pages;
    @ManyToOne
    private Language language;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private Set<Category> categories;
    @OneToMany
    private Set<BookCopy> bookCopies;
    @ManyToMany
    private Set<Author> authors;

    @Column(
            name="publication_year",
            columnDefinition = "smallint"
    )
    @Convert(
            converter = YearAttributeConverter.class
    )
    private Year publicationYear;

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Year publicationYear) {
        this.publicationYear = publicationYear;
    }
}
