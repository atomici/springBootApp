package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

