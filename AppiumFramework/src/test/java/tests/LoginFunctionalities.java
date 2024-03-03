package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginFunctionalities extends BaseTest {

    @Test
    public void MedSpeed_01(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.verifyLoginPage();
        loginPage.loginToApp("qalsr1","123456");
        homePage.verifyHomePage("QA1");
    }

    @Test
    public void barcodeScanner(){
        
    }
}
