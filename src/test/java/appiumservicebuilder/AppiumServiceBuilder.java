package appiumservicebuilder;

import base.Resources;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AppiumServiceBuilder {
    AppiumDriverLocalService service;
    private static AndroidDriver<MobileElement> driver;
    DesiredCapabilities capabilities;

    private String getProperty(String parameter) {
        return Resources.getProperty("android", parameter);
    }

    @Before
    public void beforeTest() throws Exception {
        System.out.println("Iniciando Test");
        deviceCapabilities();
    }

    @Test
    public void deviceCapabilities() throws Exception {
        System.out.println("Test");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", getProperty("PLATFORM_NAME"));
        capabilities.setCapability("platformVersion", getProperty("VERSION"));
        capabilities.setCapability("deviceName", getProperty("DEVICE_NAME"));
        capabilities.setCapability("app", getProperty("PATH_APK_PARAMETRISTA"));
        capabilities.setCapability("avd", getProperty("AVD"));
        capabilities.setCapability("automationName", getProperty("AUTOMATION_NAME"));
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

    public void setupAppiumService() {
        try {

            io.appium.java_client.service.local.AppiumServiceBuilder builder = new io.appium.java_client.service.local.AppiumServiceBuilder()
                    .withCapabilities(capabilities)
                    .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
                    .withIPAddress(getProperty("IPADDRESS"))
                    //.usingPort(Port)
                    .usingAnyFreePort();

            service = builder.build();


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @After
    public void afterTest() {
        System.out.println("Finalizando Test");
        detenerDriver();
        stopAppium();
    }
}

