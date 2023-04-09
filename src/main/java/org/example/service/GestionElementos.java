package org.example.service;

import org.example.common.CategoriaException;
import org.example.dao.DaoElementosArray;
import org.example.domain.Categoria;
import org.example.domain.Elemento;

import java.io.IOException;
import java.util.List;

public class GestionElementos implements IGestionElementos {

    private DaoElementosArray dao;

    @Override
    public boolean isEmptyElementosList() {
        return dao.isEmptyElementosList();
    }

    @Override
    public List<Elemento> getListaElementos() {
        return dao.getLista();
    }

    @Override
    public boolean addElemento(Elemento elemento) throws CategoriaException {
        return dao.addElemento(elemento);
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
    public void removeElemento(Elemento elemento) {
        dao.removeElemento(elemento);
    }

    @Override
    public List<Elemento> ElementosPorNivel(int nivel) {
        return dao.consultaNivel(nivel);
    }

    @Override
    public boolean actualizarElemento(Elemento elemento,int level, String categoria, String incognita) throws CategoriaException {
        return dao.actualizarElemento(elemento, level, categoria, incognita);
    }

    @Override
    public List<Elemento> consultaElementos(boolean ascendente) {
        return dao.consultaElementos(ascendente);
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
    public boolean escribirFichero() throws Exception{
        return dao.escribirFichero();
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
