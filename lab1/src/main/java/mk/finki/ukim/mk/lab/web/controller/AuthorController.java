package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import mk.finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;
    private final AuthorService authorService;

    public AuthorController(BookService bookService, BookStoreService bookStoreService, AuthorService authorService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
        this.authorService = authorService;
    }
    @GetMapping
    public String getAuthorsPage(@RequestParam(required = false) String error, @RequestParam(name="isbn") String isbn,Model model){
        model.addAttribute("authors",authorService.listAuthors());
        model.addAttribute("isbn",isbn);
        return "listAuthors";
    }
    @PostMapping("/book-details")
    public String getsBookDetails(@RequestParam(required = false) String error,@RequestParam(value="isbn",required = false)String isbn, @RequestParam(name="authid") Long authid,Model model){
        bookService.addAuthorToBook(authid,isbn);
        return "redirect:/bookDetails?isbn="+isbn+"&authid="+authid;
    }

}
