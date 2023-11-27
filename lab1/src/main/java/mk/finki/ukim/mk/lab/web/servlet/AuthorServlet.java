package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.AuthorService;
import mk.finki.ukim.mk.lab.service.BookService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/authors")
public class AuthorServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorServlet(SpringTemplateEngine springTemplateEngine, AuthorService authorService, BookService bookService) {
        this.springTemplateEngine = springTemplateEngine;
        this.authorService = authorService;
        this.bookService = bookService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context =  new WebContext(webExchange);
        context.setVariable("authors",authorService.listAuthors());
        context.setVariable("selectedBook",req.getParameter("isbn"));
        springTemplateEngine.process(
                "listAuthors.html",
                context,
                resp.getWriter()
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String author = req.getParameter("author");
        String isbn = req.getParameter("isbn");
        bookService.addAuthorToBook(Long.valueOf(author),isbn);
        resp.sendRedirect("/bookDetailz?isbn="+isbn+"&author="+author);
    }
}
