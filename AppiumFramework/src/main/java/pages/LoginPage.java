package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import pagelocators.LoginPageLocators;
import utils.SafeActions;

public class LoginPage extends SafeActions implements LoginPageLocators {
    private static final Logger logger = Logger.getLogger(Reporter.class.getName());
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void verifyLoginPage() {
        boolean status = isElementDisplayed(LOGIN_PAGE_BANNER, SHORT_WAIT, "Login Page Banner");
        Assert.assertTrue(status, "Login page is not loaded");
    }

    public void loginToApp(String userName, String password){
        safeClearAndType(USERNAME_INPUT, userName, SHORT_WAIT, "Username in login page");
        safeClearAndType(PASSWORD_INPUT, password, SHORT_WAIT, "Password in login page");
        safeClick(SIGN_IN_BTN, SHORT_WAIT, "sign in button in login page");
    }
}
