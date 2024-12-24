package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.Author;
import co.edu.glm.librarium.model.dto.AuthorDTO;

import java.util.List;

public interface IAuthorPortIn {

    public List<Author> getAuthorsListRegistered(String name);

    public List<Author> getAliveAuthorsListYear(String name);

    public Author saveAuthor(AuthorDTO authorDTO);
}
