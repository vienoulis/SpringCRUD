package crud.model;

import javax.persistence.*;

@Entity
@Table(name = "users_roles")
@PrimaryKeyJoinColumns(value = {
        @PrimaryKeyJoinColumn(name = "roleSet_id"),
        @PrimaryKeyJoinColumn(name = "userSet_id")
})
public class UsersRole {

    @Id
    @Column(name = "userSet_id")
    private long usersId;

    @Id
    @Column(name = "roleSet_id")
    private long rolesId;

    public UsersRole() {
    }

    public UsersRole(long usersId, long rolesId) {
        this.usersId = usersId;
        this.rolesId = rolesId;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }


    public long getRolesId() {
        return rolesId;
    }

    public void setRolesId(long rolesId) {
        this.rolesId = rolesId;
    }
}
