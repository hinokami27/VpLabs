package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import mk.finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bookDetails")
public class BookDetailsController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;
    private final AuthorService authorService;


    public BookDetailsController(BookService bookService, BookStoreService bookStoreService, AuthorService authorService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
        this.authorService = authorService;
    }
    @GetMapping
    public String getBookDetails(@RequestParam(required = false) String error,@RequestParam(value="isbn",required = false)String isbn,@RequestParam(name="authid") Long authid, Model model){
        model.addAttribute("book",bookService.findBookByIsbn(isbn));
        model.addAttribute("isbn",isbn);
        model.addAttribute("authors",bookService.findBookByIsbn(isbn).getAuthors());
        return "bookDetails";
    }
}
