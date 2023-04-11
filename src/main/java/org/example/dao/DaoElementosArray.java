package org.example.dao;

import org.example.common.CategoriaException;
import org.example.domain.Elemento;

import java.io.IOException;
import java.util.List;

public interface DaoElementosArray {
    boolean addElemento(Elemento elemento) throws CategoriaException;
    List<Elemento> getLista();

    List<Elemento> consultaCategoria(String categoria);

    List<Elemento> consultaNivel(int nivel);

    void empezar();
     List<Elemento> consultaNivelDificultad(int nivel, String categoria);

    void setLista(List<Elemento> lista);

    boolean actualizarElemento(int id,int level, String categoria, String incognita);

    List<Elemento> consultaElementos(boolean ascendente);


    void removeElemento(int id);

    boolean isEmptyElementosList();
    void crearFicheros() throws IOException;
    List<Elemento> cargarFichero() throws Exception;
    boolean escribirFichero(Elemento elemento) throws Exception;

}
