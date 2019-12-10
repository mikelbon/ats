package pages;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.After;

import org.apache.commons.io.FileUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import base.SetUp;

public class ScreenShots extends SetUp{
    AndroidDriver<MobileElement> driver;

    public ScreenShots (){
        this.driver=super.getDriver();
    }

    public void capturar_pantalla()
    {
        try
        {
            AndroidDriver<MobileElement> driver = getDriver();
            String destDir = "screenshots";
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy__hh_mm_ssaa");
            new File(destDir).mkdirs();
            String destFile = dateFormat.format(new Date()) + ".png";
            FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("fallo al sacar screen");
            Assert.fail();
        }
    }

    public void capturar_pantalla_json(Scenario scenario) {
        try
        {
            AndroidDriver<MobileElement> driver = getDriver();
            final byte[] screenShot=((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenShot, "image/png");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("fallo al sacar screen");
            Assert.fail();
        }
    }
}
