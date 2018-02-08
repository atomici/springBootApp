package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private AuthorRepository authorRepository;

    public Iterable<Author> getAllAthors(){
        return authorRepository.findAll();
    }

    public Author getAuthorByFirstName(String name){
        return authorRepository.findByFirstName(name);
    }

    public Author getAuthorById(Long id){
        return authorRepository.findById(id).get();
    }
}