/*
package by.itransition.dpm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.itransition.dpm.entity.Role;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addRole(Role role) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    @Transactional
    public void deleteRole(Role role) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().delete(role);
    }

    @Override
    @Transactional
    public List<Role> getUserIdList(){
        sessionFactory.getCurrentSession().beginTransaction();
        return (List<Role>) sessionFactory.getCurrentSession()
                .createCriteria(Role.class)
                .add(Restrictions.like("role", "ROLE_USER"))
                .list();
    }
}*/
