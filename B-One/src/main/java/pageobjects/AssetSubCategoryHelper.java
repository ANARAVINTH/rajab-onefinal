package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AssetSubCategoryHelper {
    private static AssetSubCategoryHelper assertSubCategoryHelper;
    private WebDriver wd;

    public AssetSubCategoryHelper(WebDriver driver) {
        wd = driver;
    }
    public static AssetSubCategoryHelper getInstance(WebDriver driver){

        assertSubCategoryHelper  = new AssetSubCategoryHelper(driver);

        return assertSubCategoryHelper;
    }
    public AssetSubCategoryHelper clickCreate() throws InterruptedException {

        Thread.sleep(1000);

        wd.findElement(By.id("b1_head_add")).click();
        return this;
    }

    public String  getSubCategorytext() throws InterruptedException {

      Thread.sleep(5000);
      return  wd.findElement(By.xpath("//div[@class='ag-center-cols-container']/div/div[3]/div/span")).getText();

    }

    public String getSuccessMessage(){

       return wd.findElement(By.xpath("//div[@class='ant-notification-notice-message']")).getText();
    }


}
