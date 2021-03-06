package ua.karazin.ilyin.javaweb.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;

@Component
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    private String title;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private Collection<User> users;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Role() {
    }

    public Role(int id, String title, Collection<User> users) {
        this.id = id;
        this.title = title;
        this.users = users;
    }
}
