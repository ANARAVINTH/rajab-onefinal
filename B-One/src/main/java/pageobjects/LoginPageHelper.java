package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resuable.HandleExcel;

import java.io.IOException;

public class LoginPageHelper {

    private static LoginPageHelper loginHelper;
    private WebDriver wd;

    public LoginPageHelper(WebDriver driver) {
        wd = driver;
    }
    public static LoginPageHelper getInstance(WebDriver driver){

        loginHelper  = new LoginPageHelper(driver);

        return loginHelper;
    }


    public LoginPageHelper enterUsername() throws IOException {
        wd.findElement(By.id("username")).sendKeys(HandleExcel.readExcel("Login",0,1));
        return this;
    }

    public LoginPageHelper enterpassword() throws IOException {

        wd.findElement(By.id("password")).sendKeys(HandleExcel.readExcel("Login",1,1));
        return this;
    }

    public LoginPageHelper clickSignIn(){

        wd.findElement(By.xpath("//button[text()='Sign In']")).click();
        return this;
    }
}
