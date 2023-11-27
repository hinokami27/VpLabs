package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookStore {
    private Long id;
    private String name;
    private String city;
    private String address;
}
