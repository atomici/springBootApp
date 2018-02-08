package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
