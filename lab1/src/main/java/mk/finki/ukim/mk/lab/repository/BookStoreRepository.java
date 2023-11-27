package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookStoreRepository {
    List<BookStore> bookStores = new ArrayList<>();
    public BookStoreRepository(){
        bookStores.add(new BookStore(1L,"bookstore1","city1","address1"));
        bookStores.add(new BookStore(2L,"bookstore2","city2","address2"));
        bookStores.add(new BookStore(3L,"bookstore3","city3","address3"));
        bookStores.add(new BookStore(4L,"bookstore4","city4","address4"));
        bookStores.add(new BookStore(5L,"bookstore5","city5","address5"));
    }

    public List<BookStore> findAll(){
        return bookStores;
    }
    public BookStore findByID(Long id){
        return bookStores.stream().filter(b -> b.getId().equals(id)).findFirst().get();
    }
}
