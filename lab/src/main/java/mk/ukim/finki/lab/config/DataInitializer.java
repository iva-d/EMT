package mk.ukim.finki.lab.config;

import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.Country;
import mk.ukim.finki.lab.model.dto.BookDto;
import mk.ukim.finki.lab.model.enumerations.Category;
import mk.ukim.finki.lab.repository.AuthorRepository;
import mk.ukim.finki.lab.repository.BookRepository;
import mk.ukim.finki.lab.repository.CountryRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {

//    private final BookService bookService;
//
//    private final CountryService countryService;
//
//    private final AuthorService authorService;

    private final BookRepository bookRepository;

    private final AuthorRepository authorRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    private final CountryRepository countryRepository;


    @PostConstruct
    public void init() {
        Country country1 = new Country("Spain","Europe");
        Country country2 = new Country("Italy","Europe");
        Country country3 = new Country("Macedonia", "Europe");


        this.countryRepository.save(country1);
        this.countryRepository.save(country2);
        this.countryRepository.save(country3);

        Author author1 = new Author("Miguel","de Cervantes", country1);
        Author author2 = new Author("Dante","Alighieri", country2);
        Author author3 = new Author("Grigor","Prlichev", country3);


        this.authorRepository.save(author1);
        this.authorRepository.save(author2);
        this.authorRepository.save(author3);

        Book book1 = new Book("Don Quixote", Category.NOVEL, author1,10);
        Book book2 = new Book("Divine Comedy", Category.CLASSICS,author2,25);
        Book book3 = new Book("Avtobiografija", Category.BIOGRAPHY, author3,5);
        Book book4 = new Book("Inferno", Category.CLASSICS, author2,1);
        Book book5 = new Book("La Gitanilla", Category.NOVEL, author1,15);
        Book book6 = new Book("O Armatolos", Category.HISTORY, author3,8);

        BookDto bookDto1 = new BookDto(book1.getName(), book1.getCategory(), book1.getAuthor().getId(), book1.getAvailableCopies());
        BookDto bookDto2 = new BookDto(book2.getName(), book2.getCategory(), book2.getAuthor().getId(), book2.getAvailableCopies());
        BookDto bookDto3 = new BookDto(book3.getName(), book3.getCategory(), book3.getAuthor().getId(), book3.getAvailableCopies());
        BookDto bookDto4 = new BookDto(book4.getName(), book4.getCategory(), book4.getAuthor().getId(), book4.getAvailableCopies());
        BookDto bookDto5 = new BookDto(book5.getName(), book5.getCategory(), book5.getAuthor().getId(), book5.getAvailableCopies());
        BookDto bookDto6 = new BookDto(book6.getName(), book6.getCategory(), book6.getAuthor().getId(), book6.getAvailableCopies());

        this.bookRepository.save(book1);
        this.bookRepository.save(book2);
        this.bookRepository.save(book3);
        this.bookRepository.save(book4);
        this.bookRepository.save(book5);
        this.bookRepository.save(book6);
    }
}
