package model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue
    private Integer id;
    private String login;
    private String name, surname;

    @Email
    private String email;

    @Column(name = "phone_number")
    @Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNumber;
}
