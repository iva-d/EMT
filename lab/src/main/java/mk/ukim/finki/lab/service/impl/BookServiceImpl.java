package mk.ukim.finki.lab.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.dto.BookDto;
import mk.ukim.finki.lab.model.enumerations.Category;
import mk.ukim.finki.lab.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.lab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.lab.model.exceptions.BookOutOfCopies;
import mk.ukim.finki.lab.repository.AuthorRepository;
import mk.ukim.finki.lab.repository.BookRepository;
import mk.ukim.finki.lab.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto){
        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        Category category = Category.valueOf(bookDto.getCategory().toString());

        this.bookRepository.deleteBookByName(bookDto.getName());
        Book book = new Book(bookDto.getName(), category, author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setName(bookDto.getName());
        book.setAvailableCopies(bookDto.getAvailableCopies());

        Author author = authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));
        book.setAuthor(author);

        Category category = Category.valueOf(bookDto.getCategory().toString());
        book.setCategory(category);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        int availableCopies = book.getAvailableCopies();
        if(availableCopies == 0){
            throw new BookOutOfCopies(id);
        }
        book.setAvailableCopies(availableCopies - 1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
