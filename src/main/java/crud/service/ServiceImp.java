package crud.service;

import crud.dao.UserDao;
import crud.model.Role;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ServiceImp implements Service, UserDetailsService {

    @Autowired
    private UserDao dao;

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return dao.getAllUsers();
    }

    @Override
    @Transactional
    public void add(String name, String age, String password, Set<String> roleSet) {
        if (name != null && age.matches("[0-9]+")
                && password != null && !roleSet.isEmpty()) {
            User user = new User();
            Set<Role> roles = roleSet.stream().map(x -> dao.getRoleByName(x))
                    .collect(Collectors.toSet());
            user.setName(name);
            user.setAge(Integer.parseInt(age));
            user.setPassword(password);
            user.setRoleSet(roles);
            dao.addUser(user);
        }
    }

    @Transactional
    public User getUserById(String id) {
        return dao.getUserById(Long.parseLong(id));
    }

    @Transactional
    public Role getRoleByName(String role) {
        return dao.getRoleByName(role);
    }

    @Transactional
    @Override
    public void updateUser(String id, String name, String age, String password, Set<String> roleSet) {
        if (id.matches("[0-9]+") && name != null &&
                age.matches("[0-9]+") && password != null &&
                !roleSet.isEmpty()) {
//            dao.deleteUsersRole(id);
//            for (String s: roleSet) {
//                dao.addUserRole(Long.parseLong(id), getRolesId(s));
//            }
            dao.update(Long.parseLong(id), name, Integer.parseInt(age), password);
        }
    }

//    @Transactional
//    public Long getRolesId(String s) {
//        return dao.getRolesId(s);
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

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByName(username);
    }
}
