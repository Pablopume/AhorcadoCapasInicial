package config;

import org.example.common.CategoriaException;

import java.io.IOException;
import java.util.Properties;

public class Configuration {
    private Properties properties;
    private String listaElementos;

    public Configuration() throws Exception {
        try {
            properties=new Properties();
            properties.load(Configuration.class.getClassLoader().getResourceAsStream("properties"));
            this.listaElementos=properties.getProperty("listaElementos");
        }
        catch (IOException e){
            throw new Exception(e);
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String getListaElementos() {
        return listaElementos;
    }

}
