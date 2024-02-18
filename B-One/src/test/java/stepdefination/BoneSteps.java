package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.*;
import resuable.BaseCode;
import resuable.GenerateAutoData;
import resuable.ReadInputPropertyData;

import java.io.IOException;

public class BoneSteps {

    private WebDriver driver;
    private  LoginPageHelper loginPageHelper;
    private DashBoardHelper dashBoardHelper;
    private StoreHubHelper storeHubHelper;

    private CreateAssetSubCategoryHelper createAssetSubCategoryHelper;

    private AssetSubCategoryHelper assetSubCategoryHelper;


    @Given("user logins the b one application")
    public void loginApplication() throws IOException, InterruptedException {
        driver = BaseCode.navigateToUrl();
        loginPageHelper=LoginPageHelper.getInstance(driver);
        dashBoardHelper=DashBoardHelper.getInstance(driver);
        storeHubHelper= StoreHubHelper.getInstance(driver);
        createAssetSubCategoryHelper = CreateAssetSubCategoryHelper.getInstance(driver);
        assetSubCategoryHelper=AssetSubCategoryHelper.getInstance(driver);
        loginPageHelper.enterUsername().enterpassword().clickSignIn();

    }

    @When("user creates a sub category with unique data")
    public void userCreatesASubCategoryWithUniqueData() throws InterruptedException, IOException {
        dashBoardHelper.clickSettings();
        storeHubHelper.clickAssertSubCategory();
        assetSubCategoryHelper.clickCreate();
        createAssetSubCategoryHelper.enterAssertCategory().enterNewAssertSubCategory().enterDescription().clickCreate();
        Thread.sleep(1000);
        String subCategoryText = assetSubCategoryHelper.getSubCategorytext();
        String successMessage =assetSubCategoryHelper.getSuccessMessage();
        Assert.assertEquals("Success",successMessage);
        Assert.assertEquals(ReadInputPropertyData.readPropertyData(),subCategoryText);


    }

    @When("user creates a sub category with Existing data")
    public void userCreatesASubCategoryWithExistingData() throws InterruptedException, IOException {
        dashBoardHelper.clickSettings();
        storeHubHelper.clickAssertSubCategory();
        assetSubCategoryHelper.clickCreate();
        createAssetSubCategoryHelper.enterAssertCategory().enterExistingAssertSubCategory().enterDescription().clickCreate();
        Thread.sleep(1000);
        String subCategoryText = createAssetSubCategoryHelper.validateDuplicateMessage();
        Assert.assertEquals("Combination already Exits",subCategoryText);

    }
}
