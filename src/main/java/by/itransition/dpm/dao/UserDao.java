package by.itransition.dpm.dao;

import by.itransition.dpm.entity.User;

public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public User getUserByLogin(String username);
    public User getUserById(Integer id);
}
