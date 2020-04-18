package crud.dao;

import crud.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void delete(long userId) {

    }

    @Override
    public User getUserById(Long id) {
        return null;
    }


    @Override
    public boolean isAdmin(String name) {
        return false;
    }

    @Override
    public boolean authUser(String name, String password) {
        return false;
    }

    @Override
    public void update(long userId, String name, String age, String passport, String password, String role) {

    }
}
