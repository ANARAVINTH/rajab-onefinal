package resuable;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseCode {

    public static WebDriver driver;
    public static Properties properties;

    public static WebDriver navigateToUrl() throws IOException {

        FileInputStream fis = new FileInputStream(new File("src/main/resources/configuration/config.properties"));
        properties = new Properties();
        properties.load(fis);

        switch (properties.getProperty("browser").toLowerCase()) {
            case "chrome" -> driver = new ChromeDriver();
            case "edge" -> driver = new EdgeDriver();
            case "safari" -> driver = new SafariDriver();
            default -> throw new InvalidArgumentException("enter valid browser name");
        }

        driver.get(properties.getProperty("environment"));
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        return driver;

    }
}
