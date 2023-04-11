package org.example.service;

import org.example.common.CategoriaException;
import org.example.dao.DaoElementosArray;
import org.example.dao.DaoElementosArrayImplementacion;
import org.example.domain.Elemento;

import java.io.IOException;
import java.util.List;

public class GestionElementos implements IGestionElementos {
private final DaoElementosArray dao=new DaoElementosArrayImplementacion();

    public DaoElementosArray getDao() {
        return dao;
    }

    @Override
    public boolean isEmptyElementosList() {
        return dao.isEmptyElementosList();
    }

    @Override
    public List<Elemento> getListaElementos() {
        return dao.getLista();
    }

    public void empezar() throws Exception {
        dao.cargarFichero();
    }

    @Override
    public boolean addElemento(Elemento elemento) throws CategoriaException {
        return dao.addElemento(elemento);
    }

    public void setLista(List<Elemento> lista) {
         dao.setLista(lista);
    }
    @Override
    public List<Elemento> consulta(String categoria) {
        return dao.consultaCategoria(categoria);
    }

    @Override
    public List<Elemento> consulta(int nivel) {
        return dao.consultaNivel(nivel);
    }

    @Override
    public void removeElemento(int id) {
        dao.removeElemento(id);
    }

    @Override
    public List<Elemento> ElementosPorNivel(int nivel) {
        return dao.consultaNivel(nivel);
    }

    @Override
    public boolean actualizarElemento(int id,int level, String categoria, String incognita) throws CategoriaException {
        return dao.actualizarElemento(id, level, categoria, incognita);
    }

    @Override
    public List<Elemento> consultaElementos(boolean ascendente) {
        return dao.consultaElementos(ascendente);
    }
    public List<Elemento> consultaNivelDificultad(int nivel, String categoria){
        return dao.consultaNivelDificultad(nivel, categoria);
    }

    @Override
    public List<Elemento> getListaElementosCategoria(String categoria) {
        return dao.consultaCategoria(categoria);
    }

    @Override
    public void crearFicheros() throws IOException {
        dao.crearFicheros();
    }

    @Override
    public List<Elemento> cargarFichero() throws Exception {
        return dao.cargarFichero();
    }

    @Override
    public boolean escribirFichero(Elemento elemento) throws Exception{
        return dao.escribirFichero(elemento);
    }

    @Override
    public boolean escribirFicheroBinario() {
        return false;
    }

    @Override
    public boolean cargarFicheroBinario() {
        return false;
    }
}
