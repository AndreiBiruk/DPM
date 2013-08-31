package by.itransition.dpm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.itransition.dpm.entity.User;

@Repository
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserByLogin(String login) {
        List<?> userList = sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.like("LOGIN", login))
                .list();
        return userList.size() > 0 ? (User)userList.get(0) : null;

    }

    @Override
    public User getUserById(Integer id) {
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }
}
