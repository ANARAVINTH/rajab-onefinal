package stepdefination;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import resuable.BaseCode;

import java.io.IOException;

public class Hooks extends BaseCode {


    @Before
    public void setup() throws IOException {


    }
    @AfterStep
    public void end(Scenario sc){
        byte [] byteImage =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        sc.attach(byteImage,"image/png","test");

    }
}
