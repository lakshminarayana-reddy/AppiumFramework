package pagelocators;

import org.openqa.selenium.By;

public interface HomePageLocators {
    public static By WELCOME_MSG = By.xpath("//*[@text='Welcome %s!']");
}
