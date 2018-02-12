package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAthors() {
        List<Author> list = new ArrayList<Author>();
        authorRepository.findAll().forEach(list::add);
        return list;
    }

    public Author getAuthorByFirstName(String name) {
        Optional<Author> opt = authorRepository.findByFirstName(name);
        return opt.orElse(null);
    }

    public Author getAuthorById(Long id) {
        Optional<Author> opt = authorRepository.findById(id);
        return opt.orElse(null);
    }

    public void deleteAuthorById(Long id) {
        Optional<Author> opt = authorRepository.findById(id);
        if (opt.isPresent())
            authorRepository.deleteById(id);
    }
}
