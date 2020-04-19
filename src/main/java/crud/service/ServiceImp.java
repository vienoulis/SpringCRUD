package crud.service;

import crud.dao.UserDao;
import crud.model.Role;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
            User user = new User(name, Integer.parseInt(age), password, Role.getRole(role));
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
            Role thisRole = Role.getRole(role);
            dao.update(Long.parseLong(id), name, Integer.parseInt(age), password, thisRole);
        }
    }

    @Transactional
    public void delete(String userId) {
        if (userId.matches("[0-9]+")) {
            dao.delete(Long.parseLong(userId));
        }
    }
}
