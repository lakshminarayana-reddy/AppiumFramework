package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class SafeActions implements Waits{
    public AppiumDriver<MobileElement> driver;
    private static final Logger logger = Logger.getLogger(Reporter.class.getName());

    public SafeActions(AppiumDriver<MobileElement> driver){
        this.driver = driver;
    }

    /**
     * Purpose - To verify the element is displayed or not
     * @param locator
     * @param timeout
     * @param friendlyMessage
     * @return
     */
    public boolean isElementDisplayed(By locator, int timeout, String friendlyMessage) {
        boolean result = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            result = wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
            if(result){
                logger.info(friendlyMessage+" is displayed");
            }
        } catch (Exception e) {
            logger.warn("Element "+friendlyMessage+" is not Displayed, Timed Out !!!");
        }
        return result;
    }

    public void safeClearAndType(By locator, String text, int waitTime, String elementName) {
        try {
            isElementDisplayed(locator, waitTime, elementName);
            MobileElement element = driver.findElement(locator);
            element.clear();
            Thread.sleep(1000);
            element.sendKeys(text);
            logger.info("Entered value '" + text + "' in the '" + elementName + "' element");
        } catch (Exception e) {
            logger.info("Unable to enter value '" + text + "' in the '" + elementName + "' element");
            e.printStackTrace();
        }
    }

    public void safeClick(By locator, int waitTime, String elementName) {
        MobileElement element = driver.findElement(locator);
        try {
            isElementDisplayed(locator, waitTime, elementName);
            element.click();
            logger.info("clicked on'" + elementName + "' element");
        } catch (Exception e) {
            logger.info("Unable to click on the '" + elementName + "' element");
            e.printStackTrace();
        }
    }

    public static By getNewLocator(By locator, String dynamicText) {
        String locatorType = locator.toString().split(": ")[0].split("\\.")[1];
        String newLocatorString = String.format(locator.toString().split(": ")[1], dynamicText);
        switch (locatorType) {
            case "xpath":
                locator = By.xpath(newLocatorString);
                break;
            case "cssSelector":
                locator = By.cssSelector(newLocatorString);
                break;
            case "id":
                locator = By.id(newLocatorString);
                break;
            case "className":
                locator = By.className(newLocatorString);
                break;
            case "name":
                locator = By.name(newLocatorString);
                break;
            case "linkText":
                locator = By.linkText(newLocatorString);
                break;
            case "partialLinkText":
                locator = By.partialLinkText(newLocatorString);
                break;
            case "tagName":
                locator = By.tagName(newLocatorString);
                break;
        }
        return locator;
    }

    public void scanBarcode(String barcode){

    }
}
