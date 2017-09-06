package automationFramework.supportMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadFile {
    private Properties properties = new Properties();

    private FileInputStream readFile(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public String readProperty(File file, String key) throws IOException {
        String value=null;
        if (file.exists()){
            properties.load(readFile(file));
            value= properties.getProperty(key);
        }
        return value;
    }
}
