package by.itransition.dpm.dao;

import java.util.List;

import by.itransition.dpm.entity.Role;

public interface RoleDao {
    public void addRole(Role role);
    public void deleteRole(Role role);
    public List<Role> getUserIdList();
}