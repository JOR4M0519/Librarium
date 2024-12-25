package co.edu.glm.librarium.services;

import co.edu.glm.librarium.exception.AppException;
import co.edu.glm.librarium.model.AuthorEntity;
import co.edu.glm.librarium.model.dto.AuthorDTO;
import co.edu.glm.librarium.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService implements IAuthorPortIn{

    @Autowired
    AuthorRepo authorRepo;

    @Override
    public List<AuthorEntity> getAuthorsListRegistered() {
         return (List<AuthorEntity>) authorRepo.findAll();
    }

    @Override
    public List<AuthorEntity> getAliveAuthorsListYear(short year) {
        return authorRepo.findAliveAuthorsListYear(year);
    }

    @Override
    public AuthorEntity saveAuthor(AuthorDTO authorDTO){
        AuthorEntity authorEntity = new AuthorEntity();

        authorEntity.setName(authorDTO.name());
        authorEntity.setBirthYear(authorDTO.birthYear());
        authorEntity.setDeathYear(authorDTO.deathYear());

        try{
            AuthorEntity validateAuthor = validateDuplicate(authorEntity);
            if(validateAuthor == null)
                authorRepo.save(authorEntity);

            return validateAuthor;
        }catch (DataIntegrityViolationException e){
            throw new AppException("Libro ya registrado",409);
        }catch (Exception e){
            e.printStackTrace();
            throw new AppException("Error",409);
        }
    }

    public AuthorEntity validateDuplicate(AuthorEntity authorEntity){
        List<AuthorEntity> authorEntityList = authorRepo.findByNameAndBirthYearAndDeathYear(
                authorEntity.getName(),
                authorEntity.getBirthYear(),
                authorEntity.getDeathYear());
         if(authorEntityList.size() > 0) return null;
        return authorEntityList.get(1);
    }

}
