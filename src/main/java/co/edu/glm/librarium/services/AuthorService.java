package co.edu.glm.librarium.services;

import co.edu.glm.librarium.exception.AppException;
import co.edu.glm.librarium.model.Author;
import co.edu.glm.librarium.model.Book;
import co.edu.glm.librarium.model.dto.AuthorDTO;
import co.edu.glm.librarium.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements IAuthorPortIn{

    @Autowired
    AuthorRepo authorRepo;

    @Override
    public List<Author> getAuthorsListRegistered(String name) {
        return null;
    }

    @Override
    public List<Author> getAliveAuthorsListYear(String name) {
        return null;
    }

    @Override
    public Author saveAuthor(AuthorDTO authorDTO){
        Author author = new Author();

        author.setName(authorDTO.name());
        author.setBirthYear(authorDTO.birthYear());
        author.setDeathYear(authorDTO.deathYear());

        try{
            if(!validateDuplicate(author)) authorRepo.save(author);
            return author;
        }catch (DataIntegrityViolationException e){
            throw new AppException("Libro ya registrado",409);
        }
    }

    public boolean validateDuplicate(Author author){
        if(authorRepo.findByNameAndBirthYearAndDeathYear(
                author.getName(),
                author.getBirthYear(),
                author.getDeathYear())
                .size() > 0) return true;
        return false;
    }

}
