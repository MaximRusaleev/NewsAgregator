package ru.sbrf.newsagregator.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    /*@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Collection<Tag> tags;*/

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        //tags = new ArrayList<>();
    }

    /*public void addTag(Tag tag) {
        tag.setUser(this);
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
