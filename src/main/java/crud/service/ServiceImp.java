package crud.service;

import crud.dao.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImp  implements Service {

    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return dao.getAllUsers();
    }

    @Transactional
    public void add(String name, String age, String passport) {
        if (name != null && age.matches("[0-9]+") && passport.matches("[0-9]+")) {
            User user = new User(name, Integer.parseInt(age), Long.parseLong(passport));
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
    public void update(String id, String name, String age, String passport) {
        if (id.matches("[0-9]+") && name != null &&
                age.matches("[0-9]+") && passport.matches("[0-9]+")) {
            dao.update(Long.parseLong(id), name, Integer.parseInt(age), Long.parseLong(passport));
        }
    }

    @Transactional
    public void delete(String userId) {
        if (userId.matches("[0-9]+")) {
            dao.delete(Long.parseLong(userId));
        }
    }
}
