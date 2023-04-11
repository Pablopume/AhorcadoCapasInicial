package org.example.common;

public class TamanyoExcepcion extends Exception{
    public TamanyoExcepcion() {
        super("Ese tamaño no es adecuado, o la letra ya había sido introducida o el carácter no pertenece al alfabeto");
    }
}
