package co.edu.glm.librarium.model.dto;

import co.edu.glm.librarium.model.AuthorEntity;
import co.edu.glm.librarium.model.Book;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
        @JsonAlias("id") Integer id,
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorDTO> authorDTOList,  // Asegúrate de que esta lista sea de AuthorBookDTO
        @JsonAlias("languages") List<String> languagesList,
        @JsonAlias("copyright") boolean copyright,
        @JsonAlias("download_count") int downloadCount
) implements Book<AuthorDTO> {
    @Override
    public List<AuthorDTO> authorList() {
        return this.authorDTOList;
    }

    // No es necesario escribir métodos como id(), title() y authorList() ya que el record los genera automáticamente
}

