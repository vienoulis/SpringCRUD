package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void delete(long userId);

    User getUserById(Long id);

    boolean isAdmin(String name);

    boolean authUser(String name, String password);

    void update(long userId, String name, String age, String passport, String password, String role);
}
