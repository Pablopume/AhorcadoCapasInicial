package org.example.dao;

import org.example.domain.Elemento;

import java.util.ArrayList;
import java.util.List;

public class ElementosArray {
private final List<Elemento> lista;

    public ElementosArray() {
        this.lista = new ArrayList<>();
    }

    public List<Elemento> getLista() {
        return lista;
    }
}
