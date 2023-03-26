package mk.ukim.finki.lab.config;

import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.model.dto.BookDto;
import mk.ukim.finki.lab.model.enumerations.Category;
import mk.ukim.finki.lab.service.AuthorService;
import mk.ukim.finki.lab.service.BookService;
import mk.ukim.finki.lab.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final BookService bookService;

    private final CountryService countryService;

    private final AuthorService authorService;

    public DataInitializer(BookService bookService, CountryService countryService, AuthorService authorService) {
        this.bookService = bookService;
        this.countryService = countryService;
        this.authorService = authorService;
    }

    @PostConstruct
    public void init() {
        Country country1 = new Country("Spain","Europe");
        Country country2 = new Country("Italy","Europe");
        Country country3 = new Country("Macedonia", "Europe");

        Author author1 = new Author("Miguel","de Cervantes", country1);
        Author author2 = new Author("Dante","Alighieri", country2);
        Author author3 = new Author("Grigor","Prlichev", country3);

        Book book1 = new Book("Don Quixote", Category.NOVEL, author1,10);
        Book book2 = new Book("Divine Comedy", Category.CLASSICS,author2,25);
        Book book3 = new Book("Avtobiografija", Category.BIOGRAPHY, author3,5);

        BookDto bookDto1 = new BookDto(book1.getName(), book1.getCategory(), book1.getAuthor(), book1.getAvailableCopies());
        BookDto bookDto2 = new BookDto(book2.getName(), book2.getCategory(), book2.getAuthor(), book2.getAvailableCopies());
        BookDto bookDto3 = new BookDto(book3.getName(), book3.getCategory(), book3.getAuthor(), book3.getAvailableCopies());

        this.bookService.save(bookDto1);
        this.bookService.save(bookDto2);
        this.bookService.save(bookDto3);
    }
}
