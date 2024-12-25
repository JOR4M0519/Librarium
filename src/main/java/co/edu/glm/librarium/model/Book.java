package co.edu.glm.librarium.model;

import java.util.List;

public interface Book<A> {
    Integer id();  // ID del libro
    String title();  // Título del libro
    List<A> authorList();  // Lista de autores genérica
    int downloadCount();  // Número de descargas
}

