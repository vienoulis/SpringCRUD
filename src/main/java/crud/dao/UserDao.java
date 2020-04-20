package crud.dao;

import crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void addUser(User user);

    void delete(long userId);

    User getUserById(Long id);

    void update(long userId, String name, int age, long passport);
}
