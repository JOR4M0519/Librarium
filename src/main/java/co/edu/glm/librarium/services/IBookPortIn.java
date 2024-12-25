package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.AuthorEntity;
import co.edu.glm.librarium.model.BookEntity;
import co.edu.glm.librarium.model.dto.BookDTO;

import java.util.List;

public interface IBookPortIn {

    public List<BookEntity> getBooksListRegistered();


    public List<BookEntity> getBooksListRegisteredByLanguage(String language);

    void saveBook(BookDTO bookDTO, List<AuthorEntity> authorEntityList);
}
