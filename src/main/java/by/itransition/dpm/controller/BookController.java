package by.itransition.dpm.controller;


import by.itransition.dpm.entity.Book;
import by.itransition.dpm.entity.Chapter;
import by.itransition.dpm.entity.User;
import by.itransition.dpm.service.BookService;
import by.itransition.dpm.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    ChapterService chapterService;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("createBook")
    String createBook (){
        return "createBook";
    }

    @RequestMapping("createChapter")
    String createChapter (){
        return "createChapter";
    }


    @RequestMapping(value = "addBook")
    public String registration(@ModelAttribute("book")Book book, Model model, HttpServletRequest request){
        bookService.addBook(book);
        return "redirect:/user";
    }

    @RequestMapping(value = "addChapter")
    public String addChapter(@ModelAttribute("book")Book book, Model model, HttpServletRequest request){
        bookService.addBook(book);
        return "redirect:/user";
    }

    @RequestMapping(value = "book/delete/{bookId}")
    public String delete(@ModelAttribute("book")Book book, @PathVariable Integer bookId){
        bookService.deleteBookById(bookId);
        return "redirect:/user";
    }



    @RequestMapping("/book/{bookid}")
    public String book(Model model, @PathVariable Integer bookid) {
        Book book = bookService.getBookById(bookid);
        model.addAttribute("name", book.getName());
        model.addAttribute("chapters", book.getChapters());
        //model.addAttribute("books", bookService.getUserBooks(user));
        return "book";
    }
}
