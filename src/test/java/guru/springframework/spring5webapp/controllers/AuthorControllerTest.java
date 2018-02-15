package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.services.AuthorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class AuthorControllerTest {

    @Mock
    AuthorService authorService;

    @Mock
    Model model;

    AuthorController authorController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        authorController = new AuthorController(authorService);
    }


    @Test
    public void getAllAthors() throws Exception {
        List<Author> authors = new ArrayList<>();
        authors.add(new Author());
        authors.add(new Author());

        when(authorService.getAllAthors()).thenReturn(authors);
        ArgumentCaptor<List<Author>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        String viewName = authorController.getAllAthors(model);
        assertEquals("authors", viewName);
        verify(authorService, times(1)).getAllAthors();
        verify(model, times(1)).addAttribute(eq("authors"), argumentCaptor.capture());
        List<Author> listAuth = argumentCaptor.getValue();
        assertEquals(2, listAuth.size());
    }
}