package org.example.dao;

import config.Configuration;
import org.example.domain.Elemento;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class DaoElementosArrayImplementacion implements DaoElementosArray {

    private List<Elemento> lista = new ArrayList<>();

    private Configuration config;

    private int contador=0;
    public DaoElementosArrayImplementacion() {

    }

    @Override
    public List<Elemento> getLista() {
        return lista;
    }

    public Configuration getConfig() {
        return config;
    }



    @Override
    public boolean addElemento(Elemento elemento) {
        return lista.add(elemento);
    }

    @Override
    public List<Elemento> consultaCategoria(String categoria) {
        List<Elemento> lista2 = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (this.lista.get(i).getCategoria().equals(categoria)) {
                lista2.add(this.lista.get(i));
            }
        }
        return lista2;
    }

    @Override
    public List<Elemento> consultaNivel(int nivel) {
        List<Elemento> lista2 = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            if (this.lista.get(i).getLevel() == nivel) {
                lista2.add(this.lista.get(i));
            }
        }
        return lista2;
    }


        @Override
        public List<Elemento> consultaNivelDificultad(int nivel, String categoria) {
            List<Elemento> lista2 = new ArrayList<>();
            for (int i = 0; i < lista.size(); i++) {
                if (this.lista.get(i).getLevel() == nivel && this.lista.get(i).getCategoria().equals(categoria)) {
                    lista2.add(this.lista.get(i));
                }
            }
            return lista2;
        }

    public Elemento buscarElemento(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                return lista.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean actualizarElemento(int id, int level, String incognita, String categoria) {
        Elemento elemento1 = buscarElemento(id);
        lista.remove(elemento1);
        elemento1.setLevel(level);
        elemento1.setIncognita(incognita);
        elemento1.setCategoria(categoria);

        return lista.add(elemento1);
    }

    @Override
    public List<Elemento> consultaElementos(boolean ascendente) {
        System.out.println(this.lista.size());
        List<Elemento> lista2;
        lista2=this.lista;
        if (ascendente) {
            lista2.sort(Elemento::compareTo);
        }
        return lista2;
    }

    public void empezar() {
        this.cargarFichero();
    }

    @Override
    public void setLista(List<Elemento> lista) {
        this.lista = lista;
    }



    @Override
    public void removeElemento(int id)
    {Elemento elemento1=buscarElemento(id);
        lista.remove(elemento1);
    }

    public void crearFicheros() throws IOException {
        File archivo = new File("data/listaElementos");
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
    }

    @Override
    public boolean isEmptyElementosList() {
        return lista.isEmpty();
    }

    public List<Elemento> cargarFichero() {
        List<Elemento> listaE=new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get(Configuration.getInstance().getProperty("pathLista")), StandardCharsets.UTF_8);
            lines.forEach(line -> {
                String[] article = line.split(";");
                listaE.add(new Elemento(Integer.parseInt(article[0]), Integer.parseInt(article[1]), article[2], article[3]));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaE;
    }

    public boolean escribirFichero(Elemento elemento) throws Exception {
        boolean resultado = false;

        contador++;
        try {
            if(this.contador==1) {
                Path path = Paths.get(Configuration.getInstance().getProperty("pathLista"));
                BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
                bufferedWriter.write(elemento.toString());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
            else {
                FileWriter fileWriter = new FileWriter(Configuration.getInstance().getProperty("pathLista"), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(elemento.toString());
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
            resultado = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

}