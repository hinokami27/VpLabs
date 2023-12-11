package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.ReviewService;
import org.springframework.ui.Model;
import mk.finki.ukim.mk.lab.service.BookService;
import mk.finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookStoreService  bookStoreService;
    private final AuthorService authorService;
    private final ReviewService reviewService;

    public BookController(BookService bookService, BookStoreService bookStoreService, AuthorService authorService, ReviewService reviewService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
        this.authorService = authorService;
        this.reviewService = reviewService;
    }
    @GetMapping()
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        model.addAttribute("books",bookService.listBooks());
        model.addAttribute("bookStores",bookStoreService.findAll());
        return "listBooks";
    }
    @PostMapping("/show-authors")
    public String chooseAuthor(@RequestParam(required = false) String error,@RequestParam(name="isbn") String isbn, Model model){
        model.addAttribute("isbn",isbn);
        return "redirect:/author?isbn="+isbn;
    }
    @GetMapping("/add-form")
    public String goToAdd(Model model){
        model.addAttribute("bookStores",bookStoreService.findAll());
        return "addBook";
    }
    @PostMapping("/add")
    public String saveBook(@RequestParam String title,@RequestParam String isbn,@RequestParam String genre,@RequestParam int year,@RequestParam Long id){
        this.bookService.saveBook(title,isbn,genre,year,id);
        return "redirect:/books";
    }
//    @PostMapping("/edit/{id}")
//    public String editBook(@PathVariable Long bookId){
//
//    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        this.bookService.deleteById(id);
        return "redirect:/books";
    }
    @GetMapping("/reviews/{id}")
    public String bookReviews(@PathVariable Long id,Model model){
        model.addAttribute("reviews",reviewService.findReviewsByBook(bookService.findBookById(id)));
        return "booksReviews";
    }
}
