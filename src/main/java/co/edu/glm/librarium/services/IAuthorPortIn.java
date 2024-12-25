package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.AuthorEntity;
import co.edu.glm.librarium.model.dto.AuthorDTO;

import java.util.List;

public interface IAuthorPortIn {

    public List<AuthorEntity> getAuthorsListRegistered();

    public List<AuthorEntity> getAliveAuthorsListYear(short year);

    public AuthorEntity saveAuthor(AuthorDTO authorDTO);
}
