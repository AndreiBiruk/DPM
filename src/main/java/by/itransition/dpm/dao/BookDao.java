package by.itransition.dpm.dao;

import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.User;

import java.util.List;

public interface BookDao {
    public Book getBookById(Integer id);
    public void saveBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(Book book);
    public List <Book> getAllBooks();
    public List <Book> getAllUserBooks(User user);
}
