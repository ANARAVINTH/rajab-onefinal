package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resuable.GenerateAutoData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CreateAssetSubCategoryHelper {
    private static CreateAssetSubCategoryHelper assertSubCategoryHelper;
    private WebDriver wd;

    private  String subCategoryTypeText;

    private Properties prop;

    public CreateAssetSubCategoryHelper(WebDriver driver) {
        wd = driver;
    }
    public static CreateAssetSubCategoryHelper getInstance(WebDriver driver){

        assertSubCategoryHelper  = new CreateAssetSubCategoryHelper(driver);

        return assertSubCategoryHelper;
    }
    public CreateAssetSubCategoryHelper enterAssertCategory() throws InterruptedException {

        Thread.sleep(1000);
        wd.findElement(By.xpath("//span[@class='anticon anticon-close-circle']")).click();
        wd.findElement(By.xpath("//div[@name='parentAssetType']/div/span[2]")).click();
        wd.findElement(By.xpath("//div[@label='IT Assets']")).click();

        return this;
    }

    public CreateAssetSubCategoryHelper enterNewAssertSubCategory() throws IOException {
        readNewData();
        wd.findElement(By.xpath("//input[@name='assetTypeName']")).sendKeys(subCategoryTypeText);
        return this;
    }

    public CreateAssetSubCategoryHelper enterExistingAssertSubCategory() throws IOException {
        wd.findElement(By.xpath("//input[@name='assetTypeName']")).sendKeys("Joystick");
        return this;
    }

    public CreateAssetSubCategoryHelper enterDescription(){
        wd.findElement(By.xpath("//*[@name='description']")).sendKeys("test");
        return this;
    }

    public CreateAssetSubCategoryHelper clickCreate(){
        wd.findElement(By.id("b1_stepper_next")).click();
        return this;
    }

    public String validateDuplicateMessage(){
        return wd.findElement(By.xpath("//div[@class='ant-notification-notice-message']")).getText();
    }

    public String readNewData() throws IOException {
        GenerateAutoData.getGeneratedData();
        FileInputStream fis = new FileInputStream(new File("src/main/resources/configuration/input.properties"));
        prop = new Properties();
        prop.load(fis);
        subCategoryTypeText= prop.getProperty("subCategoryType");
        return subCategoryTypeText;
    }








}
