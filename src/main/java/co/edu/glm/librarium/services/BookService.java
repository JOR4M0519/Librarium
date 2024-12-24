package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.dto.BookDTO;
import co.edu.glm.librarium.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookPortIn{

    @Autowired
    BookRepo bookRepo;


    @Override
    public List<BookDTO> getBooksListRegistered(String name) {
        return null;
    }

    @Override
    public List<BookDTO> getBooksListRegisteredByLanguage(String name) {
        return null;
    }
}
