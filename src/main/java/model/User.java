package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String name, surname;
    @Column(nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "phone_number")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
    @OneToMany
    private Set<Reservation> reservations;
    @ManyToOne
    private Permission permission;
    @OneToMany
    private Set<Penalty> pentalties;
    @OneToMany
    private Set<Borrow> borrows;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
