package co.edu.glm.librarium.services;

import co.edu.glm.librarium.exception.AppException;
import co.edu.glm.librarium.model.Author;
import co.edu.glm.librarium.model.Book;
import co.edu.glm.librarium.model.dto.BookDTO;
import co.edu.glm.librarium.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookPortIn{

    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Book> getBooksListRegistered(String name) {
        return null;
    }

    @Override
    public List<Book> getBooksListRegisteredByLanguage(String name) {
        return null;
    }

    @Override
    public void saveBook(BookDTO bookDTO, List<Author> authorList) {

        Book book = new Book();
        book.setId(bookDTO.id());
        book.setTitle(bookDTO.title());
        book.setCopyright(bookDTO.copyright());
        book.setDownloadCount(bookDTO.downloadCount());
        book.setLanguagesList(bookDTO.languagesList());
        book.setAuthorDTOList(authorList);

        try{
            bookRepo.save(book);
        }catch (DataIntegrityViolationException e){
            throw new AppException("Libro ya registrado",409);
        }


    }
}
