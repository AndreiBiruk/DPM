package by.itransition.dpm.dao;

import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.Chapter;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ChapterDaoImpl implements ChapterDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Chapter getChapterById(Integer id) {
        return (Chapter) sessionFactory.getCurrentSession().get(Chapter.class, id);
    }

    @Override
    @Transactional
    public void saveChapter(Chapter chapter) {
        sessionFactory.getCurrentSession().save(chapter);
    }

    @Override
    @Transactional
    public void updateChapter(Chapter chapter) {
        sessionFactory.getCurrentSession().update(chapter);
    }

    @Override
    @Transactional
    public void deleteChapter(Chapter chapter) {
        sessionFactory.getCurrentSession().delete(chapter);
    }

    @Override
    @Transactional
    public List<Chapter> getChaptersByBook(Book book) {
        return (List<Chapter>) sessionFactory.getCurrentSession()
                .createCriteria(Chapter.class)
                .add(Restrictions.like("book", book))
                .list();
    }
}
