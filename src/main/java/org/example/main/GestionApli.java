package org.example.main;

import org.example.common.CategoriaException;
import org.example.domain.Elemento;
import org.example.service.GestionElementos;

import java.util.Scanner;

public class GestionApli {

    public void apli() throws CategoriaException {
        GestionElementos ge=new GestionElementos();
        Scanner sc=new Scanner(System.in);
        int num;
        do {

            System.out.println("Escribe 0 para salir, 1 para listar diccionario ordenado, 2 para añadir elemento, 3 para modificar algún elemento del diccionario,4 para eliminar un elemento del diccionario");
            num=sc.nextInt();
        switch (num) {
            case 1: ge.consultaElementos(true).forEach(System.out::println);
            break;

            case 2:
                System.out.println("Pon un id");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.println("Pon un nombre");
                String nombre=sc.nextLine();
                System.out.println("Pon un nivel de dificultad");
                int nivel=sc.nextInt();
                sc.nextLine();
                System.out.println("Ponle una categoria");
                String categoria=sc.nextLine();
                ge.addElemento(new Elemento(id,nivel,nombre,categoria));

        }
        }
        while (num!=0);
    }
}
