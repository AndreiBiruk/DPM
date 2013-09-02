package by.itransition.dpm.service;

import by.itransition.dpm.dao.BookDao;
import by.itransition.dpm.dao.ChapterDao;
import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChapterService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private ChapterDao chapterDao;

    @Autowired
    private BookService bookService;

    @Transactional
    public void addChapter(Integer idBook, Chapter chapter){
        Book book = bookService.getBookById(idBook);
        book.getChapters().add(chapter);
        chapter.setBook(book);
        bookDao.updateBook(book);
    }

    @Transactional
    public List<Chapter> getbookChapters(Book book) {
        return book.getChapters();
    }

    @Transactional
    public Chapter getChapterById(Integer id){
        return chapterDao.getChapterById(id);
    }
}
