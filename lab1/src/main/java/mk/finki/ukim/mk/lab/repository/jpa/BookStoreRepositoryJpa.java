package mk.finki.ukim.mk.lab.repository.jpa;

import mk.finki.ukim.mk.lab.model.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreRepositoryJpa extends JpaRepository<BookStore,Long> {
    List<BookStore> findAll();
    BookStore findBookStoreById(Long id);
}
