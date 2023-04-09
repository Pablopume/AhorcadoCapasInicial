package org.example.domain;

import java.util.Comparator;

public class Elemento implements Comparable<Elemento> {
    private int id;
    private int level;
    private String incognita;
    private String categoria;

    public Elemento(int id, int level, String incognita, String categoria) {
        this.id = id;
        this.level = level;
        this.incognita = incognita;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public String getIncognita() {
        return incognita;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setIncognita(String incognita) {
        this.incognita = incognita;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int compareTo(Elemento o) {
        int comparador=0;
        if (this.incognita.charAt(0) < o.incognita.charAt(0)) {
            comparador = -1;
        } else if (this.incognita.charAt(0) == o.incognita.charAt(0)) {
            comparador = 0;
        } else if (this.incognita.charAt(0) > o.incognita.charAt(0)) {
            comparador = 1;

        }
        return comparador;

    }
    public Elemento(String line){
        String[] parts = line.split(";");
        this.id = Integer.parseInt(parts[0]);
        this.level = Integer.parseInt(parts[1]);
        this.incognita = parts[2];
        this.categoria= parts[3];

    }

    public String toString(){
        return id + ";" + level + ";" + incognita + ";" + categoria;
    }


}
