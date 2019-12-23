package pl.mwyrzyk.transitapi.config;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Singleton
@Startup
public class ApplicationProperties {

    private Properties properties;

    @PostConstruct
    public void init() {
        InputStream inputStream;
        String applicationPropertiesVmPath = System.getProperty("appProps");
        try {
            if (applicationPropertiesVmPath != null) {
                inputStream = new FileInputStream(new File(applicationPropertiesVmPath));
            } else {
                inputStream = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            }

            properties = new Properties();
            if (inputStream == null)
                throw new IOException();

            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public String getProperty(String propertyName) {
       return  properties.getProperty(propertyName);
    }
}
