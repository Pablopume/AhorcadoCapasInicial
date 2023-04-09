package org.example.dao;

import config.Configuration;
import org.example.domain.Elemento;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class DaoElementosArrayImplementacion implements DaoElementosArray {
    protected final ElementosArray lista;
    private Configuration config;

    public List<Elemento> getLista() {
        return lista.getLista();
    }

    public DaoElementosArrayImplementacion() {
        this.lista = new ElementosArray();
    }

    @Override
    public boolean addElemento(Elemento elemento) {
        return lista.getLista().add(elemento);
    }

    @Override
    public List<Elemento> consultaCategoria(String categoria) {
        List<Elemento> lista2 = new ArrayList<>();
        for (int i = 0; i < lista.getLista().size(); i++) {
            if (this.lista.getLista().get(i).getCategoria().equals(categoria)) {
                lista2.add(this.lista.getLista().get(i));
            }
        }
        return lista2;
    }

    @Override
    public List<Elemento> consultaNivel(int nivel) {
        List<Elemento> lista2 = new ArrayList<>();
        for (int i = 0; i < lista.getLista().size(); i++) {
            if (this.lista.getLista().get(i).getLevel() == nivel) {
                lista2.add(this.lista.getLista().get(i));
            }
        }
        return lista2;
    }

    @Override
    public List<Elemento> consultaNivelDificultad(int nivel, String categoria) {
        List<Elemento> lista2 = new ArrayList<>();
        for (int i = 0; i < lista.getLista().size(); i++) {
            if (this.lista.getLista().get(i).getLevel() == nivel && this.lista.getLista().get(i).getCategoria().equals(categoria)) {
                lista2.add(this.lista.getLista().get(i));
            }
        }
        return lista2;
    }

    public Elemento buscarElemento(int id) {
        for (int i = 0; i < lista.getLista().size(); i++) {
            if (lista.getLista().get(i).getId() == id) {
                return lista.getLista().get(i);
            }
        }
        return null;
    }

    @Override
    public boolean actualizarElemento(Elemento elemento, int level, String incognita, String categoria) {
        Elemento elemento1 = buscarElemento(elemento.getId());
        elemento1.setId(elemento.getId());
        elemento1.setLevel(elemento.getLevel());
        elemento1.setIncognita(elemento.getIncognita());
        elemento1.setCategoria(elemento.getCategoria());
        lista.getLista().remove(elemento);
        return lista.getLista().add(elemento1);
    }

    @Override
    public List<Elemento> consultaElementos(boolean ascendente) {
        List<Elemento> lista2 = lista.getLista();

        if (ascendente) {
            lista2.sort(Elemento::compareTo);
        }
        return lista2;
    }


    @Override
    public void removeElemento(Elemento elemento) {
        lista.getLista().remove(elemento);
    }

    public void crearFicheros() throws IOException {
        File archivo = new File("data/listaElementos");
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
    }

    @Override
    public boolean isEmptyElementosList() {
        return lista.getLista().isEmpty();
    }

    public List<Elemento> cargarFichero() throws Exception {
        List<Elemento> lista = new ArrayList<>();
        BufferedReader bf;
        Path p = Paths.get(config.getListaElementos());
        try {
            bf = Files.newBufferedReader(p, StandardCharsets.UTF_8);
            bf.lines().forEach(s -> lista.add(new Elemento(s)));
            bf.close();

        } catch (IOException e) {
            throw new Exception(e);
        }
        return lista;
    }

    public boolean escribirFichero() throws Exception {
        boolean resultado;
        List<Elemento> listaE = lista.getLista();
        BufferedWriter bf;
        Path p = Paths.get(config.getListaElementos());
        try {
            bf = Files.newBufferedWriter(p, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
            for (Elemento elemento : listaE) {
                bf.write(elemento.toString());
                bf.newLine();
            }
            bf.close();
            resultado = true;
        } catch (IOException e) {
            throw new Exception(e);
        }
        return resultado;

    }

}