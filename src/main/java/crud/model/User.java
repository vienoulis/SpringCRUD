package crud.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "age")
    private int age;


    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> role;

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public User() {
    }

    public User(String name, int age, String password, Set<Role> role) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    public User(long id, String name, int age, String password, Set<Role> role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.password = password;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRole();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, password, role);
    }
}