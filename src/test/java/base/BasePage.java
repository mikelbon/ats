package base;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class BasePage {
    protected AndroidDriver driver;
    protected WebDriverWait wait;
    private int seconds = 15;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, seconds);
    }

    public void wait(AndroidElement elementLocation) {

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(elementLocation));

    }


    public void wait_element(AndroidElement elementLocation) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(elementLocation));

    }

    public void swipeToButton() {
        /*Dimension dim = driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        int x = width / 2;

        int top_y = (int) (height * 0.80);
        int bottom_y = (int) (height * 0.20);
        System.out.println("Coordinates : " + top_y + " " + bottom_y);
        TouchAction ts = new TouchAction(driver);
        ts.press(x, top_y).moveTo(x, bottom_y).release().perform();*/
        //new TouchAction(driver).tap(tapOptions().withElement(elementLocation(myElement, xPoint, yPoint))).perform();

        //TouchAction touchAction = new TouchAction(driver);
        //touchAction.tap(new PointOption().withCoordinates(1280, 1013)).perform();

        TouchAction ts = new TouchAction(driver);
        ts.press(new PointOption().withCoordinates(35, 2280)).moveTo(new PointOption().withCoordinates(1412, 2280)).release().perform();
    }


    public void click(AndroidElement elementLocation) {
        elementLocation.click();
    }

    public void sendKeys(AndroidElement elementLocation, String text) {
        elementLocation.sendKeys(text);
        driver.hideKeyboard();
    }

    public String getText(AndroidElement elementLocation) {
        return elementLocation.getText();
    }

    public boolean isDisplayed(AndroidElement elementLocation) {
        return elementLocation.isDisplayed();
    }

    public void clear(AndroidElement elementLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(elementLocation));
        elementLocation.clear();
    }

    public void modificar_red() {
        //turn red
        driver.toggleWifi();
        driver.toggleData();
        System.out.println("turn red");

    }


    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}


