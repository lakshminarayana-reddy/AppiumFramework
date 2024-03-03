package base;

import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.JSONObject;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.*;

/* Used by Launch Arguments */

public class AppiumController {
    /**
     * Purpose - Get desired capabilities for Appium session
     * @param platform
     * @param udid
     * @param systemPort
     * @param app
     * @param deviceName
     * @return
     */
    public DesiredCapabilities getDesiredCapabilities(String platform, String udid, String systemPort, String app, String deviceName) {
        System.out.println("Setting up capabilities for the: test platform:" + platform);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (platform) {
            case "android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Emulator");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                capabilities.setCapability(MobileCapabilityType.UDID, udid);
                capabilities.setCapability("autoGrantPermissions", true);
                capabilities.setCapability("systemPort", systemPort);
                capabilities.setCapability("newCommandTimeout", 210);
                capabilities.setCapability("androidInstallTimeout", 210000);
                capabilities.setCapability("adbExecTimeout", 210000);
                capabilities.setCapability("uiautomator2ServerInstallTimeout", 210000);
                capabilities.setCapability("avdLaunchTimeout", 210000);
                capabilities.setCapability("avdReadyTimeout", 210000);
                capabilities.setCapability("app", app);
                return capabilities;
            case "AndroidDevice":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                capabilities.setCapability("autoGrantPermissions", true);
                capabilities.setCapability("newCommandTimeout", 210);
                capabilities.setCapability("androidInstallTimeout", 210000);
                capabilities.setCapability("adbExecTimeout", 210000);
                return capabilities;
            default:
                throw new IllegalStateException("Unexpected value: " + platform);
        }
    }
}
