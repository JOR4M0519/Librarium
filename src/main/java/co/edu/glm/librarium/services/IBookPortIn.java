package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.dto.BookDTO;

import java.util.List;

public interface IBookPortIn {

    public List<BookDTO> getBooksListRegistered(String name);

    public List<BookDTO> getBooksListRegisteredByLanguage(String name);

}
