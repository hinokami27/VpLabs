package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositoryJpa extends JpaRepository<Book,Long> {
    Book findBookByIsbn(String isbn);
    List<Book> findAll();
    Book findBookById(Long id);
    void deleteBookById(Long id);
}
