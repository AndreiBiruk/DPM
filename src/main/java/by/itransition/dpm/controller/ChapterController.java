package by.itransition.dpm.controller;

import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.Chapter;
import by.itransition.dpm.service.BookService;
import by.itransition.dpm.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChapterController {

    @Autowired
    BookService bookService;

    @Autowired
    ChapterService chapterService;

    @RequestMapping("/book/{bookId}")
    public String book(Model model, @PathVariable Integer bookId) {
        Book book = bookService.getBookById(bookId);
        model.addAttribute("name", book.getName());
        model.addAttribute("chapters", book.getChapters());
        return "book";
    }

    @RequestMapping(value = "/book/{bookId}/addChapter")
    public String addChapter(@ModelAttribute("chapter")Chapter chapter, @PathVariable Integer bookId){
        chapterService.addChapter(bookId, chapter);
        return "redirect:/book/{bookId}";
    }

    @RequestMapping("/book/{bookId}/createChapter")
    String createChapter (@PathVariable Integer bookId, Model model){
        model.addAttribute("bookId", bookId);
        return "createChapter";
    }

}
