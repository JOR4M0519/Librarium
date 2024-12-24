package co.edu.glm.librarium.view;

import java.util.Scanner;

public class View {
    private Scanner scan;

    public View(){
        scan = new Scanner(System.in);
    }

    public String getScanIN(String message){
        System.out.println(message);
        return scan.next();
    }

    public void sendMessageOUT(String message){
        System.out.println(message);
    }

    public void getMenu(){
        System.out.println("Selecciona una de las siguientes opciones");
        System.out.println( "\n--- Menú de Opciones ---\n");
        System.out.println( "1. Busca un libro por su nombre para registrarlo\n" +
                            "2. Listar libros registrados\n" +
                            "3. Listar autores registrados\n" +
                            "4. Listar autores registrados vivos en un determinado año\n" +
                            "5. Listar libros registrados por idioma\n" +
                            "9. Salir");
    }


}
