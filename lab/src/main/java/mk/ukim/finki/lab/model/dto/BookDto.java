package mk.ukim.finki.lab.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.enumerations.Category;

@Data
@NoArgsConstructor
public class BookDto {

    private Long id;
    private String name;
    private Category category;
    private Author author;
    private int availableCopies;

    public BookDto(String name, Category category, Author author, int availableCopies) {
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }
}
