package crud.dao;

import crud.model.Role;
import crud.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void delete(long userId);

    User getUserById(Long id);

    void update(long userId, String name, int age, String password, Set<Role> roleSet);

    Role getRoleByName(String s);

    User getUserByName(String s);
}
