package erailOrange.com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {


    public PropertyReader() //constructor created
    {
        //System.out.println("Reading the Property");
    }

    public static String readKey(String key) {
        FileInputStream fileInputStream=null;
        Properties p = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/data.properties");
            p=new Properties();
            p.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        return p.getProperty(key);
    }


}
