package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Author;
import mk.finki.ukim.mk.lab.model.Book;
import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    List<Book> books = new ArrayList<>();
    private final BookStoreRepository bookStoreRepository;

    public BookRepository(BookStoreRepository bookStoreRepository){
        this.bookStoreRepository = bookStoreRepository;
        List<BookStore> bookStores = bookStoreRepository.bookStores;
        books.add(new Book("1111111111111","book1","genre1",2011, 1L,bookStores.get(0)));
        books.add(new Book("2222222222222","book2","genre2",2012, 2L,bookStores.get(1)));
        books.add(new Book("3333333333333","book3","genre3",2013, 3L,bookStores.get(2)));
        books.add(new Book("4444444444444","book4","genre4",2014, 4L,bookStores.get(3)));
        books.add(new Book("5555555555555","book5","genre5",2015, 5L,bookStores.get(4)));
    }
    public List<Book> findAll(){
        return books;
    }
    public Book findByIsbn(String isbn){
        return books.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().get();
    }
    public void addAuthorToBook(Author author, Book book){
        List<Author> bookAuthors = book.getAuthors();
        bookAuthors.add(author);
        book.setAuthors(bookAuthors);
    }

    public void addBookToBooks(String title, String isbn, String genre, int year, Long id) {
        Long nbId = Long.valueOf(books.size()+1);
        Book newBook = new Book(isbn,title,genre,year,nbId,bookStoreRepository.findByID(id));
        books.add(newBook);
    }
    public Book findByID(Long id){
        return books.stream().filter(b -> b.getId().equals(id)).findFirst().get();
    }

    public void deleteById(Long id) {
        books.removeIf(b -> b.getId().equals(id));
    }
}
