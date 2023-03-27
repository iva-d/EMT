package mk.ukim.finki.lab.web.rest;

import mk.ukim.finki.lab.model.Book;
import mk.ukim.finki.lab.model.dto.BookDto;
import mk.ukim.finki.lab.model.exceptions.BookNotFoundException;
import mk.ukim.finki.lab.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable Long id) {
        return this.bookService.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.edit(id, bookDto)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty())
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/rent/{id}")
    public ResponseEntity rent(@PathVariable Long id) {
        Book book = this.bookService.findById(id).orElseThrow(() -> new BookNotFoundException(id));
        int numCopies = book.getAvailableCopies();
        this.bookService.rentById(id);
        if(book.getAvailableCopies() < numCopies)
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
}
