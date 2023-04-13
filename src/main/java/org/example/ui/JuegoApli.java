package org.example.ui;

import org.example.domain.Juego;
import org.example.domain.Jugador;
import org.example.service.GestionElementos;

import java.util.Scanner;

public class JuegoApli {

    public void apli() throws Exception {
        GestionElementos ge = new GestionElementos();
        ge.setLista(ge.cargarFichero());
        String palabra;
        int palabra2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu nombre");
        Jugador jug1 = new Jugador(sc.nextLine());
        do {
            Juego jue = Juego.Introduccion(ge, sc, jug1);
            String[] intento = new String[jue.getaAdivinar().getIncognita().length()];
            do {
                palabra = Juego.jugando(sc, jue, intento);
                if (palabra == null) break;
            } while (jue.getIntentos() != 7 && !jue.getaAdivinar().getIncognita().equalsIgnoreCase(palabra));
            System.out.println("Si quieres seguir jugando escribe 1, quieres parar escribe 2");
            palabra2 = sc.nextInt();
            sc.nextLine();
        }
        while (palabra2 != 2);
    }

}
