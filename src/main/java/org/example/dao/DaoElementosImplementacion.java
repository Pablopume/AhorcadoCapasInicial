package org.example.dao;

import org.example.domain.Elemento;

import java.util.ArrayList;
import java.util.List;

public class DaoElementosImplementacion implements DaoElementos {
    protected final Elementos lista;

    public DaoElementosImplementacion() {
        this.lista = new Elementos();
    }
    @Override
    public boolean addElemento(Elemento elemento) {
        return lista.getListaelementos().add(elemento);
    }

    @Override
    public List<Elemento> consulta(String categoria) {
        List<Elemento> lista2 = new ArrayList<>();
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getCategoria().equals(categoria)) {
                lista2.add(lista.getListaelementos().get(i));
            }
        }
        return lista2;
    }

    @Override
    public List<Elemento> consulta(int nivel) {
        List<Elemento> lista2 = new ArrayList<>();
        for (int i = 0; i < lista.getListaelementos().size(); i++) {
            if (lista.getListaelementos().get(i).getLevel() == nivel) {
                lista2.add(lista.getListaelementos().get(i));
            }
        }
        return lista2;
    }

    @Override
    public boolean actualizarElemento(int id) {
        return false;
    }

    @Override
    public List<Elemento> consultaElementos(boolean ascendente) {
        return null;
    }

    @Override
    public List<Elemento> getListaElemento(String categoria) {
        return lista.getListaelementos();
    }

    @Override
    public void removeElemento(Elemento elemento) {
        lista.getListaelementos().remove(elemento);
    }

    @Override
    public boolean isEmptyElementosList() {
        return lista.getListaelementos().isEmpty();
    }
}
