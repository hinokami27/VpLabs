package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Author;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AuthorRepository {
    List<Author> authors = new ArrayList<>();
    public AuthorRepository(){
        authors.add(new Author(1L, "name1", "surname1", "bio1",LocalDate.of(1990,1,1)));
        authors.add(new Author(2L,"name2","surname2","bio2",LocalDate.of(1990,2,2)));
        authors.add(new Author(3L,"name3","surname3","bio3",LocalDate.of(1990,3,3)));
        authors.add(new Author(4L,"name4","surname4","bio4",LocalDate.of(1990,4,4)));
        authors.add(new Author(5L,"name5","surname5","bio5",LocalDate.of(1990,5,5)));
    }
    public List<Author> findAll(){
        return authors;
    }
    public Author findById(Long id){
        return authors.stream().filter(a -> a.getId().equals(id)).findFirst().get();
    }
}
