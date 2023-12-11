package mk.finki.ukim.mk.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.repository.jpa.AuthorRepositoryJpa;
import mk.finki.ukim.mk.lab.repository.jpa.BookRepositoryJpa;
import mk.finki.ukim.mk.lab.repository.jpa.BookStoreRepositoryJpa;
import mk.finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepositoryJpa bookRepository;
    private final AuthorRepositoryJpa authorRepository;
    private  final BookStoreRepositoryJpa bookStoreRepository;

    public BookServiceImpl(BookRepositoryJpa bookRepository, AuthorRepositoryJpa authorRepository, BookStoreRepositoryJpa bookStoreRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookStoreRepository = bookStoreRepository;
    }


    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void addAuthorToBook(Long authorId, String isbn) {
        List<Author> bookAuthors = bookRepository.findBookByIsbn(isbn).getAuthors();
        bookAuthors.add(authorRepository.findAuthorById(authorId));
        bookRepository.findBookByIsbn(isbn).setAuthors(bookAuthors);
    }


    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    @Override
    @Transactional
    public void saveBook(String title, String isbn, String genre, int year,Long id) {
        bookRepository.save(new Book(title,isbn,genre,year,bookStoreRepository.findBookStoreById(id)));
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteBookById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
