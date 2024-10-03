package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        try {
            FileInputStream fis = new FileInputStream("src/main/java/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
