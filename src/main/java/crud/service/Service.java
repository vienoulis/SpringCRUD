package crud.service;

import crud.model.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Set;

public interface Service {
    List<User> getUsers();

    void add(String name, String age, String password, Set<String> roleSet);

    User getUserById(String id);

    void update(String id, String name, String age, String password, Set<String> roleSet);

    void delete(String userId);

    User getUserByName(String nmae);
}
