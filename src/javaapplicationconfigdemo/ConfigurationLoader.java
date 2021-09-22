package javaapplicationconfigdemo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author 30039802 Caspian Maclean
 */
public class ConfigurationLoader {

    InputStream inputStream;

    public Properties loadProperties() throws IOException {
        try {
            Properties properties = new Properties();
            String propFileName = "config.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file: '" + propFileName + "' not found.");
            }
            return properties;
        } catch (IOException ex) {
            System.out.println("Exception: " + ex);
            throw ex;
        }
    }
}
