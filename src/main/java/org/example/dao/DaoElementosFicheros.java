package org.example.dao;

import org.example.domain.Juego;

import java.io.*;

public class DaoElementosFicheros {
    public DaoElementosFicheros() {
    }

    public static final String FICHEROB= "FicheroBinario";

    public static Juego cargarFicheroBinario() {
        Juego auxiliar = null;
        File file = new File(FICHEROB);
        if (file.exists()) {
            try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(file))) {
                auxiliar = (Juego) is.readObject();

            } catch (IOException | ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(DaoElementosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);

            }
        }
        return auxiliar;
    }


    public static boolean escribirFicheroBinario(Juego juego) {
        boolean escrito = false;
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FICHEROB))) {
            os.writeObject(juego);
            escrito = true;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(DaoElementosFicheros.class.getName()).log(java.util.logging.Level.SEVERE, ex.getMessage(), ex);
        }
        return escrito;
    }
}
