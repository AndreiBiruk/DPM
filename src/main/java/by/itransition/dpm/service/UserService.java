package by.itransition.dpm.service;

import by.itransition.dpm.dao.UserDao;
import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    void addBook (User user, Book book){
        user.getBooks().add(book);
    }

    @Transactional
    public User getUserByLogin(String username) {
        return userDao.getUserByLogin(username);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
