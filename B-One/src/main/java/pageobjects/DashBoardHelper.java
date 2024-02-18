package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardHelper {
    private static DashBoardHelper dashBoardHelper;
    private WebDriver wd;

    public DashBoardHelper(WebDriver driver) {
        wd = driver;
    }
    public static DashBoardHelper getInstance(WebDriver driver){

        dashBoardHelper  = new DashBoardHelper(driver);

        return dashBoardHelper;
    }
    public DashBoardHelper clickSettings() throws InterruptedException {
        Thread.sleep(8000);
        wd.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-colorInherit MuiIconButton-edgeStart MuiIconButton-sizeMedium css-1c5vh3u']/following::button[3]")).click();
        return this;
    }




}
