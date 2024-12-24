package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.dto.AuthorDTO;
import co.edu.glm.librarium.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorPortIn{

    @Autowired
    AuthorRepo authorRepo;

    @Override
    public List<AuthorDTO> getAuthorsListRegistered(String name) {
        return null;
    }

    @Override
    public List<AuthorDTO> getAliveAuthorsListYear(String name) {
        return null;
    }
}
