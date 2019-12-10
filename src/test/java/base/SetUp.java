package base;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.service.DriverService;
import org.testng.Assert;
import org.testng.reporters.Files;

import base.Resources;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.deps.com.thoughtworks.xstream.io.path.Path;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class SetUp {
    Scenario scenario;

    @Before
    public void beforeScenario() {
        try {
            deviceCapabilities();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
            Assert.fail();
        }
    }

    @After
    public void afterScenario() {
        try {
            detenerDriver();
            stopAppium();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String getProperty(String parameter) {
        return Resources.getProperty("android", parameter);
    }

    AppiumDriverLocalService service;
    private static AndroidDriver<MobileElement> driver;
    DesiredCapabilities capabilities;

    public void deviceCapabilities() throws Exception {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", getProperty("PLATFORM_NAME"));
        capabilities.setCapability("version", getProperty("VERSION"));
        capabilities.setCapability("deviceName", getProperty("DEVICE_NAME"));
        capabilities.setCapability("app", getProperty("PATH_APK_ATSALUD"));
        capabilities.setCapability("avd", getProperty("AVD"));
        capabilities.setCapability("fullReset", getProperty("FULLRESET"));

        try {
            setupAppiumService();
            startAppium();
            driver = new AndroidDriver<MobileElement>(service.getUrl(), capabilities);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (Exception e) {
            throw new Exception("Error connecting to Appium service : " + e.getMessage());
        }
    }

    public void setupAppiumService() {
        try {
            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withCapabilities(capabilities)
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress(getProperty("IPADDRESS"))
                    .usingAnyFreePort();
            service = builder.build();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void startAppium() {
        service.start();
    }

    public void stopAppium() {
        service.stop();
    }

    public void detenerDriver() {
        driver.quit();
    }

    public static AndroidDriver<MobileElement> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void startActivity() {
        driver = new AndroidDriver<MobileElement>(service.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}
