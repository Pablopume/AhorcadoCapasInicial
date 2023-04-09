package org.example.dao;

import org.example.domain.Categoria;
import org.example.domain.Elemento;

import java.io.IOException;
import java.util.List;

public interface DaoElementosArray {
    boolean addElemento(Elemento elemento);
    List<Elemento> getLista();

    List<Elemento> consultaCategoria(String categoria);

    List<Elemento> consultaNivel(int nivel);



    List<Elemento> consultaNivelDificultad(int nivel, String categoria);

    boolean actualizarElemento(Elemento elemento,int level, String categoria, String incognita);

    List<Elemento> consultaElementos(boolean ascendente);


    void removeElemento(Elemento elemento);

    boolean isEmptyElementosList();
    void crearFicheros() throws IOException;
    List<Elemento> cargarFichero() throws Exception;
    boolean escribirFichero() throws Exception;

}
