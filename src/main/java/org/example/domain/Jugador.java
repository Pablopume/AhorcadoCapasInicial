package org.example.domain;

import java.io.Serializable;

public class Jugador implements Serializable {
    private String nombre;
    private int puntuacion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
    }
}
