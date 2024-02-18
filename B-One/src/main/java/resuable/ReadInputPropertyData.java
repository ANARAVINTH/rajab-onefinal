package resuable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadInputPropertyData {

    public static Properties prop;
    public static String readPropertyData() throws IOException {

        FileInputStream fis = new FileInputStream(new File("src/main/resources/configuration/input.properties"));
        prop = new Properties();
        prop.load(fis);
        String subCategoryTypeText= prop.getProperty("subCategoryType");
        return subCategoryTypeText;
    }
}
