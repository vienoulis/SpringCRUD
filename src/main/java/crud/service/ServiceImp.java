package crud.service;

import crud.dao.UserDao;
import crud.model.Role;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@org.springframework.stereotype.Service
public class ServiceImp implements Service {

    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return dao.getAllUsers();
    }

    @Transactional
    public void add(String name, String age, String password, String role) {
        if (name != null && age.matches("[0-9]+") && password != null && role != null) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(new Role(1L, "ROLE_USER"));
            User user = new User(name, Integer.parseInt(age), password, roleSet);
            if (!getUsers().contains(user)) {
                dao.addUser(user);
            }
        }
    }

    @Transactional
    public User getUserById(String id) {
        return dao.getUserById(Long.parseLong(id));
    }

    @Transactional
    public void update(String id, String name, String age, String password, String role) {
        if (id.matches("[0-9]+") && name != null && password != null &&
                age.matches("[0-9]+") && role.matches("[a-zA-z]+")) {
            Set<Role> roleSet = new HashSet<>();
            roleSet.add(new Role(1L, "ROLE_USER"));
            dao.update(Long.parseLong(id), name, Integer.parseInt(age), password, roleSet);
        }
    }

    @Transactional
    public void delete(String userId) {
        if (userId.matches("[0-9]+")) {
            dao.delete(Long.parseLong(userId));
        }
    }
}
