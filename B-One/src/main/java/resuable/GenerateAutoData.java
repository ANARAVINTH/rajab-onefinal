package resuable;

import com.github.javafaker.Faker;

import java.io.*;
import java.util.Properties;
import java.util.Random;

public class GenerateAutoData {
    public static void getGeneratedData() throws IOException {

        Faker faker = new Faker();

        String generatedString = faker.company().name();

        Properties properties = new Properties();
        try(OutputStream outputStream = new FileOutputStream("src/main/resources/configuration/input.properties")){
            properties.setProperty("subCategoryType", generatedString );
            properties.store(outputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
