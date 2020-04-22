package crud.service;

import crud.dao.UserDao;
import crud.model.Role;
import crud.model.User;
import javafx.print.Collation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceImp implements Service {

    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public void add(String name, String age, String password, Set<String> roleSet) {

    }

    @Transactional
    public User getUserById(String id) {
        return dao.getUserById(Long.parseLong(id));
    }

    @Transactional
    public Role getRoleByName(String role){
        return dao.getRoleByName(role);
    }



    @Transactional
    @Override
    public void update(String id, String name, String age, String password, Set<String> roleSet) {
        if (id.matches("[0-9]+") && name != null &&
                age.matches("[0-9]+") && password != null &&
                !roleSet.isEmpty()) {
            Set<Role> roles = roleSet.stream()
                    .map(this::getRoleByName)
                    .collect(Collectors.toSet());
            dao.update(Long.parseLong(id), name, Integer.parseInt(age), password, roles);
        }
    }

//    @Transactional
//    public void update(String id, String name, String age, String password) {
//        if (id.matches("[0-9]+") && name != null &&
//                age.matches("[0-9]+") && password != null) {
//            dao.update(Long.parseLong(id), name, Integer.parseInt(age), Long.parseLong(passport));
//        }
//    }

    @Transactional
    public void delete(String userId) {
        if (userId.matches("[0-9]+")) {
            dao.delete(Long.parseLong(userId));
        }
    }

    @Transactional
    @Override
    public User getUserByName(String name) {
        return dao.getUserByName(name);
    }
}
