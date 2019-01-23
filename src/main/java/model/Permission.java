package model;

import javax.persistence.*;

@Entity
@Table(name="permissions")
public class Permission {
    @Id
    private int id;
    @Column(name="manage_books")
    private boolean manageBooks;
    @Column(name="manage_all_users")
    private boolean manageAllUsers;
    @Column(name="manage_members")
    private boolean manageMembers;
}
