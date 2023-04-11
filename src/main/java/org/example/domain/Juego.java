package org.example.domain;

public class Juego {
    private Elemento aAdivinar;
    private Jugador jugador;
    private int intentos;

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public Juego(Elemento aAdivinar, Jugador jugador) {
        this.aAdivinar = aAdivinar;
        this.jugador = jugador;
        this.intentos = 0;
    }

    public Elemento getaAdivinar() {
        return aAdivinar;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getIntentos() {
        return intentos;
    }
}
