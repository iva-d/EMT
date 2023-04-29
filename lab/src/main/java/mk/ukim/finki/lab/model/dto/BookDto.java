package mk.ukim.finki.lab.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.enumerations.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String name;
    private Category category;
    private Long author;
    private int availableCopies;
}
