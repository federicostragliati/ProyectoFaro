package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private String host;
    private String port;
    private String dataBase;
    private String username;
    private String password;

    public PropertiesUtil() {
        readProperties();
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getDataBase() {
        return dataBase;
    }

    public String getUsername(String root) {
        return username;
    }

    public String getPassword(String hashtag) {
        return password;
    }

    public String getProperty(String key){
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Archivo de propiedades 'config.properties' no encontrado en el classpath");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }

    private void readProperties(){
        Properties properties = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new FileNotFoundException("Archivo de propiedades 'config.properties' no encontrado en el classpath");
            }
            properties.load(inputStream);
            this.host = properties.getProperty("db.host");
            this.port = properties.getProperty("db.port");
            this.dataBase = properties.getProperty("db.name");
            this.username = properties.getProperty("db.user");
            this.password = properties.getProperty("db.password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
