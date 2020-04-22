package crud.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToMany(mappedBy = "roleSet", fetch = FetchType.EAGER)
//    @JoinTable(name = "users_roles",
//            //foreign key for EmployeeEntity in employee_car table
//            joinColumns = @JoinColumn(name = "user_id"),
//            //foreign key for other side - EmployeeEntity in employee_car table
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<User> userSet = new HashSet<>();

    public Role() {
    }


    public Role(Long id, String role, Set<User> userSet) {
        this.id = id;
        this.role = role;
        this.userSet = userSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long ig) {
        this.id = ig;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String toString() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role) &&
                Objects.equals(userSet, role1.userSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, userSet);
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
