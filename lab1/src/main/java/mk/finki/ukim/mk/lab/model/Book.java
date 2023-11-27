package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private String genre;
    private int year;
    private List<Author> authors;
    private Long id;
    private BookStore bookStore;

    public Book(String isbn, String title, String genre, int year,Long id,BookStore bookStore){
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = new ArrayList<>();
        this.id = id;
        this.bookStore=bookStore;
    }

}
