package by.itransition.dpm.dao;

import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Book getBookById(Integer id) {
        return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    @Override
    @Transactional
    public void deleteBook(Book book) {
        sessionFactory.getCurrentSession().delete(book);
    }

    @Override
    @Transactional
    public void deleteBookById(Integer id) {
        Book book = getBookById(id);
        book.getUser().getBooks().remove(book);
        deleteBook(book);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        return (List<Book>) sessionFactory.getCurrentSession().createQuery("from Book").list();
    }

    @Override
    @Transactional
    public List<Book> getAllUserBooks(User user) {
        return (List<Book>) sessionFactory.getCurrentSession()
                .createCriteria(Book.class)
                .add(Restrictions.like("user", user))
                .list();
    }
}
