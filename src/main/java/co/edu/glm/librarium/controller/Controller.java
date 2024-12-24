package co.edu.glm.librarium.controller;



import co.edu.glm.librarium.model.Author;
import co.edu.glm.librarium.model.dto.BookDTO;
import co.edu.glm.librarium.model.dto.ListBookDTO;
import co.edu.glm.librarium.services.AuthorService;
import co.edu.glm.librarium.services.BookService;
import co.edu.glm.librarium.util.GutendexUtil;
import co.edu.glm.librarium.view.View;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private final View view;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public Controller(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.view = new View(); // O inyecta también 'View' si es manejada por Spring
    }

    public void launchProgram() {
        int control = 0;



        while (control != 9){
            view.getMenu();
            try{
                control = Integer.parseInt(view.getScanIN("\nIngrese una opcion"));

                launchOptions(control);
            }catch (NumberFormatException e){
                view.sendMessageOUT("Error al ingresar una opción");
                launchProgram();
            }

        }
    }

    public void launchOptions(int option){


        switch (option) {
            case 1:
                GutendexUtil gutendexUtil = new GutendexUtil();
                String name = view.changeBlankSpaceFormat(view.getScanIN("Ingrese el nombre del libro que desea buscar"));

                System.out.println("Nombre a buscar "+name);

                ListBookDTO listBookDTO = gutendexUtil.getBooksListByNameGutendex(name);

                listBookDTO.bookDTOList().forEach(book -> {
                    view.sendMessageOUT("************************************************************");
                    view.sendMessageOUT("ID: "+book.id()+" - Titulo: "+ book.title());

                    view.sendMessageOUTLine("[");
                    book.authorDTOList().forEach( author ->
                    view.sendMessageOUTLine(" -"+author.name())
                    );
                    view.sendMessageOUT("]");

                    view.sendMessageOUT("# Descargas: " + book.downloadCount());
                });

                int id = Integer.parseInt(view.getScanIN("Si desea agregar un libro determinado ingrese el número id del libro, de lo contrario,\n" +
                        "escriba 8 para devolverse al menu principal"));
                if(id == 8) launchProgram();
                if(registerBookAndAuthors(gutendexUtil.getBookById(id)))
                    view.sendMessageOUT("Se guardo exitosamente la información");
                else
                    view.sendMessageOUT("Hubo un error, intentalo nuevamente");


                break;
            case 2:



                break;
            case 3:

                break;
            case 4:

                break;
            case 5:
                    //hasta aca
                break;
            case 6:

                break;
            case 7:

                break;
            case 8:

                break;
            case 9:
                view.sendMessageOUT("Saliendo del programa...");
                break;

            default:
                view.sendMessageOUT("Opción inválida. Por favor, seleccione una opción válida.");
                break;
        }
    }

    public boolean registerBookAndAuthors(BookDTO bookDTO){

        try{

            List<Author> authorList = new ArrayList<>();

            bookDTO.authorDTOList().forEach(authorDTO ->
                authorList.add(authorService.saveAuthor(authorDTO))
            );

            bookService.saveBook(bookDTO,authorList);
            return true;
        }catch (Exception e){
            //e.printStackTrace();
            //view.sendMessageOUT(e.getMessage());
            return false;
        }

    }

}
