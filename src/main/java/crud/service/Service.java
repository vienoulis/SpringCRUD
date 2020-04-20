package crud.service;

import crud.model.User;

import java.util.List;

public interface Service {
    List<User> getUsers();

    void add(String name, String age, String passport);

    User getUserById(String id);

    void update(String id, String name, String age, String passport);

    void delete(String userId);
}
