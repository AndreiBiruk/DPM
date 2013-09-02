package by.itransition.dpm.service;

import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: Андрей
 * Date: 02.09.13
 * Time: 13:42
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserService {

    void addBook (User user, Book book){
        user.getBooks().add(book);
    }

}
