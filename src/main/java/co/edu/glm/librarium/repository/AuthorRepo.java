package co.edu.glm.librarium.repository;

import co.edu.glm.librarium.model.AuthorEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepo extends CrudRepository<AuthorEntity,Integer> {
    List<AuthorEntity> findByNameAndBirthYearAndDeathYear(String name, Short birthYear, Short deathYear);

    @Query("SELECT a FROM AuthorEntity a WHERE :year >= a.birthYear AND (a.deathYear IS NULL OR :year <= a.deathYear)")
    List<AuthorEntity> findAliveAuthorsListYear(Short year);

}
