package org.example.main;

import com.github.javafaker.Faker;
import org.example.common.CategoriaException;
import org.example.dao.DaoElementosArray;
import org.example.dao.DaoElementosArrayImplementacion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Si quieres jugar pulsa 1, si eres administrador 2");
        int num = sc.nextInt();
        switch (num) {
            case 1:
                JuegoApli ju=new JuegoApli();
                ju.apli();
                break;
            case 2:
                GestionApli ge = new GestionApli();
                ge.apli();
                break;
        }

        Faker faker = new Faker();
        String nombre = faker.gameOfThrones().character();
        System.out.println(nombre);
        String animal = faker.animal().name();
        System.out.println(animal);
        String fecha = faker.date().birthday(10, 15).toString();
        System.out.println(fecha);
    }
}