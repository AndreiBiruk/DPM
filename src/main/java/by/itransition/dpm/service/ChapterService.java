package by.itransition.dpm.service;

import by.itransition.dpm.dao.BookDao;
import by.itransition.dpm.dao.ChapterDao;
import by.itransition.dpm.dao.UserDao;
import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.Chapter;
import by.itransition.dpm.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ChapterDao chapterDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Transactional
    public void addChapter(Book book, Chapter chapter){
        book.getChapters().add(chapter);
        bookDao.saveBook(book);
    }

    @Transactional
    public List<Chapter> getBookChapters(Book book) {
        return book.getChapters();
    }

    @Transactional
    public Chapter getChapterById(Integer id){
        return chapterDao.getChapterById(id);
    }
}
