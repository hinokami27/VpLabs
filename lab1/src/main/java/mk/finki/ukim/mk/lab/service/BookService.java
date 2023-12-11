package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();
    void addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);

    void saveBook(String title, String isbn, String genre, int year,Long id);
    Book findBookById(Long id);
    void deleteBookById(Long id);

    void deleteById(Long id);
}
