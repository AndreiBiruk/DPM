package by.itransition.dpm.service;

import by.itransition.dpm.dao.BookDao;
import by.itransition.dpm.dao.UserDao;
import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addBook(Book book){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userDao.getUserByLogin(name);
        book.setUser(user);
        bookDao.saveBook(book);
        userService.addBook(user, book);
    }
}
