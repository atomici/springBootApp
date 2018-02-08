package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private AuthorRepository authorRepository;

    public Iterable<Author> getAllAthors(){
        return authorRepository.findAll();
    }
}
