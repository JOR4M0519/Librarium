package co.edu.glm.librarium.model.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ListBookDTO(
        @JsonAlias("results") List<BookDTO> bookDTOList,
        @JsonAlias("count") int count
) {
}
