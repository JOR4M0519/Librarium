package co.edu.glm.librarium.controller;



import co.edu.glm.librarium.model.dto.BookDTO;
import co.edu.glm.librarium.model.dto.ListBookDTO;
import co.edu.glm.librarium.util.GutendexUtil;
import co.edu.glm.librarium.view.View;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    private View view;


    public Controller(){

        view = new View();



        launchProgram();
    }

    private void launchProgram() {
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
                String name = view.getScanIN("Ingrese el nombre del libro que desea buscar");

                ListBookDTO listBookDTO = gutendexUtil.getBooksListByNameGutendex(name);

                listBookDTO.bookDTOList().forEach(book -> {
                    view.sendMessageOUT(book.toString());
                });

                break;
            case 2:



                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

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


}
