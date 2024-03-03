package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.LocksDevice;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public AppiumDriver driver;
    private static final ThreadLocal<AppiumDriver> DRIVER_CONTAINER = new ThreadLocal<>();
    private AppiumController appiumController = new AppiumController();
    protected boolean isAndroid;
    private String appApkPath;


    @BeforeClass
    @Parameters({"platformType","deviceName","apkPath"})
    public void setUpTest(@Optional("android") String platformType,
                          @Optional("emulator-5554") String deviceName, @Optional("") String appApkPath) throws MalformedURLException {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        String udid = "";
        String systemPort = "";
        driver = new AndroidDriver(url,appiumController.getDesiredCapabilities(
                platformType,
                udid,
                systemPort,
                appApkPath,
                deviceName
        ));

        DRIVER_CONTAINER.set(driver);
    }
}
