package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.Author;
import co.edu.glm.librarium.model.Book;
import co.edu.glm.librarium.model.dto.BookDTO;

import java.util.List;

public interface IBookPortIn {

    public List<Book> getBooksListRegistered(String name);

    public List<Book> getBooksListRegisteredByLanguage(String name);

    void saveBook(BookDTO bookDTO, List<Author> authorList);
}
