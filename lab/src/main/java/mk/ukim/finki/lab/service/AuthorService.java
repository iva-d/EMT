package mk.ukim.finki.lab.service;

import mk.ukim.finki.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> save(Author author);

    List<Author> findAll();

}
