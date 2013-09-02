package by.itransition.dpm.dao;

import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.Chapter;

import java.util.List;

public interface ChapterDao {
    public Chapter getChapterById(Integer id);
    public void saveChapter(Chapter chapter);
    public void updateChapter(Chapter chapter);
    public void deleteChapter(Chapter chapter);
    public List <Chapter> getChaptersByBook(Book book);
}
