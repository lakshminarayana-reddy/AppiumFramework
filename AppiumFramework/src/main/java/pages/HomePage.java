package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import pagelocators.HomePageLocators;
import utils.SafeActions;

public class HomePage extends SafeActions implements HomePageLocators {
    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void verifyHomePage(String userName){
        boolean status = isElementDisplayed(getNewLocator(WELCOME_MSG, userName), SHORT_WAIT,"Welcome message in home page");
        Assert.assertTrue(status,"Welcome message is not displayed in home page");
    }
}
