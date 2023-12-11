package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private Integer score;
    private String description;
    @ManyToOne
    private Book book;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    public Review() {
    }
}
