package org.example.dao;

import org.example.domain.Elemento;

import java.util.List;

public interface DaoElementos {
    public boolean addElemento(Elemento elemento) ;
    public List<Elemento> consulta(String categoria);
    public List<Elemento> consulta(int nivel);
    public boolean actualizarElemento(int id) ;
    public List<Elemento> consultaElementos(boolean ascendente);
    public List<Elemento> getListaElemento(String categoria) ;
    public void removeElemento(Elemento elemento) ;
    public boolean isEmptyElementosList() ;

}
