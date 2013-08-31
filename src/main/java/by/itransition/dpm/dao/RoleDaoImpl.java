package by.itransition.dpm.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.itransition.dpm.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addRole(Role role) {
        sessionFactory.getCurrentSession().save(role);
    }

    @Override
    public void deleteRole(Role role) {
        sessionFactory.getCurrentSession().delete(role);
    }

    @Override
    public List<Role> getUserIdList(){
        return (List<Role>) sessionFactory.getCurrentSession()
                .createCriteria(Role.class)
                .add(Restrictions.like("role", "ROLE_USER"))
                .list();
    }
}