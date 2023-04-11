package org.example.main;

import org.example.common.CategoriaException;
import org.example.domain.Elemento;
import org.example.service.GestionElementos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionApli {



    public void apli() throws Exception {
        GestionElementos ge = new GestionElementos();
        Scanner sc = new Scanner(System.in);
        int num=0;
        ge.getDao().setLista(ge.getDao().cargarFichero());
        do {
            try {
                System.out.println("Escribe 0 para salir, 1 para listar diccionario ordenado, 2 para añadir elemento, 3 para modificar algún elemento del diccionario,4 para eliminar un elemento del diccionario");
                num = sc.nextInt();
                switch (num) {
                    case 1:
                        ge.consultaElementos(true).forEach(System.out::println);
                        break;
                    case 2:
                        anyadirElemento(ge, sc);
                        break;
                    case 3:
                        cambiarCampo(ge, sc);
                        break;
                    case 4:
                        System.out.println("Introduce el id del elemento a borrar");
                        int id3 = sc.nextInt();
                        ge.removeElemento(id3);
                        break;
                    default:
                        System.out.println("Has introducido una opción inexistente");
                }
            }catch (InputMismatchException e){
                System.out.println("Has introducido una letra y tienes que introducir un numero");
                sc.nextLine();
            }
        }
        while (num != 0);
        for (int i = 0; i <ge.getDao().getLista().size() ; i++) {
            ge.escribirFichero(ge.getDao().getLista().get(i));
        }

    }

    private static void anyadirElemento(GestionElementos ge, Scanner sc) throws CategoriaException {
        System.out.println("Pon un id");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Pon un nombre");
        String nombre = sc.nextLine();
        System.out.println("Pon un nivel de dificultad");
        int nivel = sc.nextInt();
        sc.nextLine();
        System.out.println("Ponle una categoria");
        String categoria = sc.nextLine();
        ge.addElemento(new Elemento(id, nivel, nombre, categoria));
    }

    private static void cambiarCampo(GestionElementos ge, Scanner sc) throws CategoriaException {
        System.out.println("Pon el id del campo que quieres cambiar");
        int id2= sc.nextInt();
        sc.nextLine();
        System.out.println("Pon el nivel del campo que quieres cambiar");
        int nivel2= sc.nextInt();
        sc.nextLine();
        System.out.println("Pon el nombre de la categoría a cambiar");
        String categ= sc.nextLine();
        System.out.println("Pon el nombre del elemento");
        String nombre2= sc.nextLine();
        ge.actualizarElemento(id2,nivel2,categ,nombre2);
        return;
    }
}
