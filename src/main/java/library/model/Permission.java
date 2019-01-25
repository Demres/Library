package library.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="PERMISSION")
public class Permission {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="manage_books", nullable = false)
    private boolean manageBooks;
    @Column(name="manage_all_users", nullable = false)
    private boolean manageAllUsers;
    @Column(name="manage_members", nullable = false)
    private boolean manageMembers;
    @OneToMany
    private Set<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isManageBooks() {
        return manageBooks;
    }

    public void setManageBooks(boolean manageBooks) {
        this.manageBooks = manageBooks;
    }

    public boolean isManageAllUsers() {
        return manageAllUsers;
    }

    public void setManageAllUsers(boolean manageAllUsers) {
        this.manageAllUsers = manageAllUsers;
    }

    public boolean isManageMembers() {
        return manageMembers;
    }

    public void setManageMembers(boolean manageMembers) {
        this.manageMembers = manageMembers;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
