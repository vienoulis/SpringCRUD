package crud.dao;

import crud.model.Role;
import crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void delete(long userId);

    User getUserById(Long id);

    void update(long userId, String name, int age, String password);

    Role getRoleByName(String s);

    User getUserByName(String s);

    void deleteUsersRole(String id);

    Long getRolesId(String s);

    void addUserRole(long id, Long rolesId);
}
