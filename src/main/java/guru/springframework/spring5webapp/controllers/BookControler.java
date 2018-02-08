package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class BookControler {

 private BookService bookService;

    public BookControler(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/books/{title}")
    public String getBookByTitle(@PathVariable String title, Model model) {
        model.addAttribute("books", bookService.getBookByTitle(title));
        return "books";
    }

    @GetMapping("/books/id/{id}")
    public String getBookByTitle(@PathVariable Long id, Model model) {
        model.addAttribute("books", bookService.getBookById(id));
        return "books";
    }

    @GetMapping("/books/{id}/delete")
    public String deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
        return "redirect:/books";
    }
}
