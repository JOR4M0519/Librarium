package co.edu.glm.librarium.repository;

import co.edu.glm.librarium.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author,Integer> {
}
