package org.example.service;

import org.example.common.CategoriaException;
import org.example.domain.Elemento;

import java.io.IOException;
import java.util.List;

public interface IGestionElementos {
    public boolean isEmptyElementosList();
    public List<Elemento> getListaElementos();
    public boolean addElemento(Elemento elemento)throws CategoriaException;
    public List<Elemento> consulta(String categoria);
    public void setLista(List<Elemento> lista);
    public List<Elemento> consulta(int nivel);
    public void removeElemento(int id);
    public List<Elemento> ElementosPorNivel(int nivel);
    void empezar() throws Exception;
    public boolean actualizarElemento(int id,int level, String categoria, String incognita) throws CategoriaException;
    public List<Elemento> consultaElementos(boolean ascendente);
    public List<Elemento> getListaElementosCategoria(String categoria);
    public void crearFicheros()throws IOException;
    public List<Elemento> consultaNivelDificultad(int nivel, String categoria);
    public List<Elemento> cargarFichero() throws Exception;
    public boolean escribirFichero(Elemento elemento) throws Exception;
    public boolean escribirFicheroBinario();
    public boolean cargarFicheroBinario();

}
