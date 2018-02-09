package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public List<Book> iterableList() {
        Iterable<Book> iterable = bookRepository.findAll();
        List<Book> book = new ArrayList<>();
        iterable.forEach(book::add);

        List<String> list = Arrays.asList("a", "b", "", "c", "");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4);


        list = list
                .stream()
                .filter(abc -> !(abc.isEmpty()))
                .collect(Collectors.toList());

        System.out.println(list);

        list1 = list1
                .stream()
                .filter(a -> a > 2)
                .collect(Collectors.toList());

        System.out.println(list1);
        book = book
                .stream()
                .filter(a -> a.getId() > 3)
                .collect(Collectors.toList());

        return book;
    }
}

