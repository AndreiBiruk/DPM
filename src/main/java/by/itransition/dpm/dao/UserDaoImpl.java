package by.itransition.dpm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.itransition.dpm.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public User getUserByLogin(String username) {
        List<?> userList = sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.like("username", username))
                .list();
        return userList.size() > 0 ? (User)userList.get(0) : null;

    }

    @Override
    @Transactional
    public User getUserById(Integer id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers(){
        return (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
    }
}
