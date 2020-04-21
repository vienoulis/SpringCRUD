package crud.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role  {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role")
    private String role;

    @ManyToMany
    @JoinTable(name = "users_cars",
            //foreign key for EmployeeEntity in employee_car table
            joinColumns = @JoinColumn(name = "cars_id"),
            //foreign key for other side - EmployeeEntity in employee_car table
            inverseJoinColumns = @JoinColumn(name = "role_id"))
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
}
