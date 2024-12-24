package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.dto.AuthorDTO;

import java.util.List;

public interface IAuthorPortIn {

    public List<AuthorDTO> getAuthorsListRegistered(String name);

    public List<AuthorDTO> getAliveAuthorsListYear(String name);
}
