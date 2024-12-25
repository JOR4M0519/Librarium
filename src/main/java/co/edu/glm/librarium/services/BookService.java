package co.edu.glm.librarium.services;

import co.edu.glm.librarium.exception.AppException;
import co.edu.glm.librarium.model.AuthorEntity;
import co.edu.glm.librarium.model.BookEntity;
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
    public List<BookEntity> getBooksListRegistered() {

        return (List<BookEntity>) bookRepo.findAll();
    }

    @Override
    public List<BookEntity> getBooksListRegisteredByLanguage(String language) {
        return bookRepo.findBooksByLanguage(language);
    }

    @Override
    public void saveBook(BookDTO bookDTO, List<AuthorEntity> authorEntityList) {

        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookDTO.id());
        bookEntity.setTitle(bookDTO.title());
        bookEntity.setCopyright(bookDTO.copyright());
        bookEntity.setDownloadCount(bookDTO.downloadCount());
        bookEntity.setLanguagesList(bookDTO.languagesList());
        bookEntity.setAuthorEntityDTOList(authorEntityList);

        try{
            bookRepo.save(bookEntity);
        }catch (DataIntegrityViolationException e){
            e.printStackTrace();
            throw new AppException("Libro ya registrado",409);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
