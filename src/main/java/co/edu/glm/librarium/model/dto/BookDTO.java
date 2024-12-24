package co.edu.glm.librarium.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(
        @JsonAlias("id") int id,
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorDTO> authorDTOList,
        @JsonAlias("languages") List<String> languagesList,
        @JsonAlias("copyright") boolean copyright,
        @JsonAlias("download_count") int downloadCount
) {

}
