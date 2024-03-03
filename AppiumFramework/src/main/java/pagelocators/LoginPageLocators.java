package pagelocators;

import org.openqa.selenium.By;

public interface LoginPageLocators {
    public static By LOGIN_PAGE_BANNER = By.xpath("//*[@class='android.widget.ImageView']");
    public static By USERNAME_INPUT = By.xpath("//*[contains(@text,'Scan Username')]");
    public static By PASSWORD_INPUT = By.xpath("//*[contains(@text,'Scan Badge Number')]");
    public static By SIGN_IN_BTN = By.xpath("//*[@text='SIGN-IN']");
}
