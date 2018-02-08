package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorController {


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    private AuthorService authorService;

    @GetMapping("/authors")
    public String getAllAthors(Model model) {
        model.addAttribute("authors", authorService.getAllAthors() );
        return "authors";
    }

    @GetMapping("/authors/{name}")
    public String getAllAthors(@PathVariable String name, Model model) {
        model.addAttribute("authors", authorService.getAuthorByFirstName(name) );
        return "authors";
    }

    @GetMapping("/authors/id/{id}")
    public String getAllAthors(@PathVariable Long id, Model model) {
        model.addAttribute("authors", authorService.getAuthorById(id) );
        return "authors";
    }

    @GetMapping("/authors/{id}/delete")
    public String deleteAuthorById(@PathVariable Long id){
        authorService.deleteAuthorById(id);
        return "redirect:/authors";
    }
}
