package co.edu.glm.librarium.repository;

import co.edu.glm.librarium.model.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepo extends CrudRepository<BookEntity,Integer> {
    // Consulta para buscar libros por idioma
    @Query("SELECT b FROM BookEntity b JOIN b.languagesList l WHERE l = :language")
    List<BookEntity> findBooksByLanguage(String language);
}
