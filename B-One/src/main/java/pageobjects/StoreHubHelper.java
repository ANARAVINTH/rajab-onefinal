package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StoreHubHelper {

    private static StoreHubHelper storeHubHelper;
    private WebDriver wd;

    public StoreHubHelper(WebDriver driver) {
        wd = driver;
    }
    public static StoreHubHelper getInstance(WebDriver driver){

        storeHubHelper  = new StoreHubHelper(driver);

        return storeHubHelper;
    }
    public StoreHubHelper clickAssertSubCategory(){

        wd.findElement(By.xpath("//*[text()='Asset Sub Category']")).click();
        return this;
    }
}
