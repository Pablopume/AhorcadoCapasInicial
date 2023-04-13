package org.example.domain;

import org.example.common.CategoriaException;
import org.example.common.TamanyoExcepcion;
import org.example.dao.DaoElementosFicheros;
import org.example.service.GestionElementos;

import java.io.Serializable;
import java.util.Scanner;

public class Juego implements Serializable {
    private Elemento aAdivinar;
    private Jugador jugador;
    private int intentos;

    private String[] intento;
    public Elemento getaAdivinar() {
        return aAdivinar;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntento(String[] intento) {
        this.intento = intento;
    }

    public String[] getIntento() {
        return intento;
    }
    public static String jugando(Scanner sc, Juego jue, String[] intento) {
        String palabra = inicioJuego(sc, jue, intento);

        if (palabra.length() == jue.getaAdivinar().getIncognita().length()) {

            if (palabra.equals(jue.getaAdivinar().getIncognita())) {
                System.out.println("¡Felicidades, has adivinado la palabra!");
                return null;
            } else {
                System.out.println("Lo siento, esa no es la palabra.");
            }
        } else if (palabra.length() != 1) {
            try {
                throw new TamanyoExcepcion();
            } catch (TamanyoExcepcion e) {
                System.out.println("Has introducido un número de carácteres diferente al de la palabra");
            }

            jue.setIntentos(jue.getIntentos() - 1);
        } /*else if (!((palabra.charAt(0) >=65) && (palabra.charAt(0) <=90)) || !((palabra.charAt(0)>=97 && (palabra.charAt(0)<=122))) ){
            try {
                throw new TamanyoExcepcion();
            }
            catch (TamanyoExcepcion e){
                System.out.println("Ese carácter no es válido");
            jue.setIntentos(jue.getIntentos()-1);
        }}*/ else {
            boolean letraEncontrada = false;

            char[] incognita = jue.getaAdivinar().getIncognita().toCharArray();
            for (int i = 0; i < incognita.length; i++) {
                letraEncontrada = isLetraEncontrada(jue, intento, palabra, letraEncontrada, i);
            }
            if (letraEncontrada) {
                System.out.println("¡Muy bien, has encontrado una letra!");
            } else {
                System.out.println("Lo siento, esa letra no está en la palabra.");
            }
        }

        jue.setIntentos(jue.getIntentos() + 1);
        return palabra;
    }

    private static boolean isLetraEncontrada(Juego jue, String[] intento, String palabra, boolean letraEncontrada, int i) {
        char palbra3 = palabra.charAt(0);
        char palbra4 = 0;
        if (palbra3 >= 65 && palbra3 <= 90) {
            palbra4 = (char) (palbra3 + 32);
        } else if (palbra3 >= 97 && palbra3 <= 122) {
            palbra4 = (char) (palbra3 - 32);
        }
        if (jue.getaAdivinar().getIncognita().charAt(i) == palbra3 || jue.getaAdivinar().getIncognita().charAt(i) == palbra4) {
            intento[i] = palabra;
            letraEncontrada = true;
        }
        return letraEncontrada;
    }

    private static String inicioJuego(Scanner sc, Juego jue, String[] intento) {
        String palabra;
        System.out.println("Llevas " + jue.getIntentos() + " de 7 intentos");
        System.out.println("Adivina la palabra de " + jue.getaAdivinar().getIncognita().length());

        dibujar(jue);
        for (int i = 0; i < intento.length; i++) {
            if (intento[i] != null) {
                System.out.print(intento[i]);
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        palabra = sc.nextLine();
        return palabra;
    }

    public static Juego Introduccion(GestionElementos ge, Scanner sc, Jugador jug1) throws CategoriaException {
        boolean categoriaExiste;
        String categoria;
        Juego juego = null;
        do {
            System.out.println("Para jugar una partida antigua escribe 1, sino escribe 2");
            int num = sc.nextInt();
            sc.nextLine();

            if (num == 2) {
                do {
                    System.out.println("Escibe la categoría deseada: Formula1, Simpsons");
                    categoria = sc.nextLine();
                    categoriaExiste = false;
                    categoriaExiste = categoriaValida(ge, categoriaExiste, categoria);
                } while (!categoriaExiste);
                System.out.println("Escribe la dificultad, van del 1 al 3, cuanto más nivel las palabras son más largas.");
                int dificultad = sc.nextInt();
                sc.nextLine();
                int numero = (int) (Math.random() * ge.consultaNivelDificultad(dificultad, categoria).size());
                System.out.println(numero);
                juego = new Juego(ge.consultaNivelDificultad(dificultad, categoria).get(numero), jug1);

            } else {
                juego = DaoElementosFicheros.cargarFicheroBinario();
                if(juego==null){
                    System.out.println("No tienes partida guardada, por favor presione 2");
                }
            }
        }while (juego==null);
        return juego;
    }

    private static boolean categoriaValida(GestionElementos ge, boolean categoriaExiste, String categoria) throws CategoriaException {
        for (int i = 0; i < ge.getLista().size(); i++) {
            if (ge.getLista().get(i).getCategoria().equalsIgnoreCase(categoria)) {
                categoriaExiste = true;
            }
        }
        if (!categoriaExiste) {
            throw new CategoriaException();
        }
        return categoriaExiste;
    }

    private static void dibujar(Juego jue) {
        if (jue.getIntentos() == 0) {
            System.out.printf(" ['''\n      +---+\n      |   |\n          |\n          |\n          |\n          |\n    =========''', '''%n");
        } else if (jue.getIntentos() == 1) {
            System.out.printf("      +---+\n      |   |\n      O   |\n          |\n          |\n          |\n    =========''', '''%n");
        } else if (jue.getIntentos() == 2) {
            System.out.printf("      +---+\n      |   |\n      O   |\n      |   |\n          |\n          |\n    =========''', '''%n");
        } else if (jue.getIntentos() == 3) {
            System.out.printf("      +---+\n      |   |\n      O   |\n     /|   |\n          |\n          |\n    =========''', ''%n");
        } else if (jue.getIntentos() == 4) {
            System.out.printf("      +---+\n      |   |\n      O   |\n     /|\\  |\n          |\n          |\n    =========''', '''%n");
        } else if (jue.getIntentos() == 5) {
            System.out.printf("      +---+\n      |   |\n      O   |\n     /|\\  |\n     /    |\n          |\n    =========''', '''%n");
        } else {
            System.out.printf("      +---+\n      |   |\n      O   |\n     /|\\  |\n     / \\  |\n          |\n    =========''']%n");
        }
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public Juego(Elemento aAdivinar, Jugador jugador) {
        this.aAdivinar = aAdivinar;
        this.jugador = jugador;
        this.intentos = 0;
    }


}
