package org.example.main;

import org.example.domain.Juego;
import org.example.domain.Jugador;
import org.example.service.GestionElementos;

import java.util.Scanner;

public class JuegoApli {

    public void apli() throws Exception {
        GestionElementos ge = new GestionElementos();
        ge.getDao().setLista(ge.getDao().cargarFichero());
        String palabra;
        int palabra2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce tu nombre");
        Jugador jug1 = new Jugador(sc.nextLine());
        do {
            Juego jue = Introduccion(ge, sc, jug1);
            String[] intento= new String[jue.getaAdivinar().getIncognita().length()];
            do {
                System.out.println("Llevas "+ jue.getIntentos() +  " de 7 intentos");
                System.out.println("Adivina la palabra de "+jue.getaAdivinar().getIncognita().length());

                dibujar(jue);
                for (int i = 0; i <intento.length ; i++) {
                    if (intento[i]!=null){
                        System.out.print(intento[i]);
                }else {
                        System.out.print("-");
                    }
                }
                palabra=sc.nextLine();


                if (palabra.length() == jue.getaAdivinar().getIncognita().length()) {

                    if (palabra.equals(jue.getaAdivinar().getIncognita())) {
                        System.out.println("¡Felicidades, has adivinado la palabra!");
                        break;
                    } else {
                        System.out.println("Lo siento, esa no es la palabra.");
                    }
                } else  if (palabra.length()!=1) {
                    System.out.println("Has introducido un número de carácteres diferente al de la palabra");
                    jue.setIntentos(jue.getIntentos()-1);
                }else {
                    boolean letraEncontrada = false;

                    char[] incognita = jue.getaAdivinar().getIncognita().toCharArray();
                    for (int i = 0; i < incognita.length; i++) {
                       char palbra3= palabra.charAt(0);
                        if (jue.getaAdivinar().getIncognita().charAt(i)==palbra3) {
                            intento[i] = palabra;
                            letraEncontrada = true;
                        }
                    }
                    if (letraEncontrada) {
                        System.out.println("¡Muy bien, has encontrado una letra!");
                    } else {
                        System.out.println("Lo siento, esa letra no está en la palabra.");

                    }
                }

                jue.setIntentos(jue.getIntentos()+1);
            } while (jue.getIntentos()!=7 && !jue.getaAdivinar().getIncognita().equals(palabra));
            System.out.println("Si quieres seguir jugando escribe 1, quieres parar escribe 2");
            palabra2=sc.nextInt();
            sc.nextLine();
        }
        while (palabra2!=2);
    }

    private static Juego Introduccion(GestionElementos ge, Scanner sc, Jugador jug1) {
        System.out.println("Escibe la categoría deseada: Formula1, Personajes de How I Met Your Mother");
        String categoria = sc.nextLine();
        System.out.println("Escribe la dificultad, van del 1 al 3, cuanto más nivel las palabras son más largas.");
        int dificultad = sc.nextInt();
        sc.nextLine();
        int numero = (int) (Math.random() * ge.getDao().consultaNivelDificultad(dificultad, categoria).size());
        System.out.println(numero);
        Juego jue = new Juego(ge.getDao().consultaNivelDificultad(dificultad, categoria).get(numero), jug1);
        return jue;
    }

    private static void dibujar(Juego jue) {
        if (jue.getIntentos()==0){
            System.out.printf(" ['''\n      +---+\n      |   |\n          |\n          |\n          |\n          |\n    =========''', '''%n");
        }
        else if (jue.getIntentos()==1){
            System.out.printf("      +---+\n      |   |\n      O   |\n          |\n          |\n          |\n    =========''', '''%n");
        } else if (jue.getIntentos()==2) {
            System.out.printf("      +---+\n      |   |\n      O   |\n      |   |\n          |\n          |\n    =========''', '''%n");
        } else if (jue.getIntentos()==3) {
            System.out.printf("      +---+\n      |   |\n      O   |\n     /|   |\n          |\n          |\n    =========''', ''%n");
        } else if (jue.getIntentos()==4) {
            System.out.printf("      +---+\n      |   |\n      O   |\n     /|\\  |\n          |\n          |\n    =========''', '''%n");
        } else if (jue.getIntentos()==5) {
            System.out.printf("      +---+\n      |   |\n      O   |\n     /|\\  |\n     /    |\n          |\n    =========''', '''%n");
        } else {
            System.out.printf("      +---+\n      |   |\n      O   |\n     /|\\  |\n     / \\  |\n          |\n    =========''']%n");
        }
    }
}
