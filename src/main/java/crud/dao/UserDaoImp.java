package crud.dao;

import crud.model.Role;
import crud.model.User;
import crud.model.UsersRole;
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
        return (User) sessionFactory.getCurrentSession().createQuery("from User where id = :id")
                .setParameter("id", id).uniqueResult();
    }


    @Override
    public Role getRoleByName(String role) {
        return (Role) sessionFactory.getCurrentSession().createQuery("from Role where role = :rl")
                .setParameter("rl", role).uniqueResult();
    }

    @Override
    public User getUserByName(String name) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where name = :nm")
                .setParameter("nm", name).uniqueResult();
    }

    @Override
    public void update(long userId, String name, int age, String password) {
        sessionFactory.getCurrentSession().createQuery("update User set name = :nm, " +
                "age = :a, password = :ps where id = :id")
                .setParameter("id", userId)
                .setParameter("nm", name)
                .setParameter("a", age)
                .setParameter("ps", password)
                .executeUpdate();
    }

    @Override
    public void deleteUsersRole(String id) {
        sessionFactory.getCurrentSession().createQuery("delete from UsersRole where usersId = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public Long getRolesId(String s) {
        return (Long) sessionFactory.getCurrentSession()
                .createQuery("select id from Role where role = :nm")
                .uniqueResult();
    }

    @Override
    public void addUserRole(long id, Long rolesId) {
        sessionFactory.getCurrentSession().save(new UsersRole(id, rolesId));
    }
}
