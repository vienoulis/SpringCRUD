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
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void delete(long userId) {
        sessionFactory.getCurrentSession().createQuery("delete from User where id = :id")
                .setParameter("id", userId).executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("from User where id = :id")
                .setParameter("id", id).uniqueResult();

        return user;
    }

    @Override
    public void update(long userId, String name, int age, long passport) {
        sessionFactory.getCurrentSession().createQuery("update User set name = :nm, " +
                "age = :a, passport = :ps where id = :id")
                .setParameter("id", userId)
                .setParameter("nm", name)
                .setParameter("a", age)
                .setParameter("ps", passport)
                .executeUpdate();
    }
}
