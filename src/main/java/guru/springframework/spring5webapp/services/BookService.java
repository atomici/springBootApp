package guru.springframework.spring5webapp.services;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        bookRepository.findAll().forEach(list::add);
        return list;
    }

    public Book getBookByTitle(String title) {
        Optional<Book> opt = bookRepository.findByTitle(title);
        return opt.orElse(null);
    }

    public Book getBookById(Long id) {
        Optional<Book> opt = bookRepository.findById(id);
        return opt.orElse(null);
    }

    public void deleteBookById(Long id) {
        if (bookRepository.findById(id).isPresent()) ;
        bookRepository.deleteById(id);
    }

    public List<Book> iterableList() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        books = books
                .stream()
                .filter(a -> a.getId() < 5)
                .collect(Collectors.toList());


        //java 8 modifying a list by criteria
        List<String> list = Arrays.asList("a", "b", "", "c", "");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 1, 2, 3, 4);

        list = list
                .stream()
                .filter(abc -> !(abc.isEmpty()))
                .collect(Collectors.toList());

        System.out.println(list);

        list1 = list1
                .stream()
                .map(a -> a * 2)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(list1);

        return books;
    }
}

