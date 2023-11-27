package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/bookDetailz")
public class BookDetailsServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final BookService bookService;
    private final AuthorService authorService;

    public BookDetailsServlet(SpringTemplateEngine springTemplateEngine, BookService bookService, AuthorService authorService) {
        this.springTemplateEngine = springTemplateEngine;
        this.bookService = bookService;
        this.authorService = authorService;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context =  new WebContext(webExchange);
        String author = req.getParameter("author");
        String isbn = req.getParameter("isbn");
        Book book = bookService.findBookByIsbn(isbn);
        List<Author> authors = book.getAuthors();
        context.setVariable("author",author);
        context.setVariable("isbn",isbn);
        context.setVariable("book",book);
        context.setVariable("authors",authors);
        springTemplateEngine.process(
                "bookDetails.html",
                context,
                resp.getWriter()
        );
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
