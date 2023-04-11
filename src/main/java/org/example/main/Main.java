package org.example.main;

import com.github.javafaker.Faker;
import org.example.common.CategoriaException;
import org.example.dao.DaoElementosArray;
import org.example.dao.DaoElementosArrayImplementacion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int num=0;
        do {

            try {
                System.out.println("Si quieres jugar pulsa 1, si eres administrador 2");

                num = sc.nextInt();

                switch (num) {
                    case 1:
                        JuegoApli ju = new JuegoApli();
                        ju.apli();
                        break;
                    case 2:
                        introducirContrasenya(sc);
                        GestionApli ge = new GestionApli();
                        ge.apli();
                        break;
                    default:
                        System.out.println("Has introducido una opción que no existe");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Introduce un número");

            }

        }
        while (num!=1 && num!=2);
    }

    private static void introducirContrasenya(Scanner sc) {
        String contrasenya="1234";
        String contra;
        do {
            System.out.println("Escribe la contraseña");
            contra= sc.nextLine();
            if (!contra.equals(contrasenya)){
                System.out.println("Contraseña incorrecta, introduzcala de nuevo");
            }
        }
        while (!contra.equals(contrasenya));
    }
}