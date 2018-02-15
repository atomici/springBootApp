package guru.springframework.spring5webapp.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    Author author;

    @Before
    public void setUp() {
        author = new Author();
    }

    @Test
    public void getId() throws Exception {
        Long id = 2L;
        author.setId(id);

        assertEquals(id, author.getId());
    }

    @Test
    public void getFirstName() throws Exception {
    }

    @Test
    public void getLastName() throws Exception {
    }

    @Test
    public void getBooks() throws Exception {
    }

}