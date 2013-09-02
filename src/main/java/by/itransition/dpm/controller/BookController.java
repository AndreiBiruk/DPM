package by.itransition.dpm.controller;


import by.itransition.dpm.entity.Book;
import by.itransition.dpm.service.BookService;
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

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("createBook")
    String createBook (){
        return "createBook";
    }

    @RequestMapping(value = "addBook")
    public String registration(@ModelAttribute("book")Book book, Model model, HttpServletRequest request){
        bookService.addBook(book);
        return "redirect:/user";
    }

    @RequestMapping(value = "book/delete/{bookId}")
    public String delete(@ModelAttribute("book")Book book, @PathVariable Integer bookId){
        bookService.deleteBookById(bookId);
        return "redirect:/user";
    }

}
