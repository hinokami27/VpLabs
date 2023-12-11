package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname ;
    private String biography;
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate dateOfBirth;

    public Author() {
    }
}
