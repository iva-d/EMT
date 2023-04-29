package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Author;
import mk.ukim.finki.lab.repository.AuthorRepository;
import mk.ukim.finki.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}
