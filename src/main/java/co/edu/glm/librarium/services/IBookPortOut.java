package co.edu.glm.librarium.services;

import co.edu.glm.librarium.model.dto.BookDTO;
import co.edu.glm.librarium.model.dto.ListBookDTO;

public interface IBookPortOut {

    public ListBookDTO getBooksListByNameGutendex(String name);

    public BookDTO getBookById(int id);

}
