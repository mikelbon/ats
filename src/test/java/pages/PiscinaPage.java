package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class PiscinaPage extends BasePage {

    public PiscinaPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    @AndroidFindBy(xpath = "//android.widget.TextView[(@text='Piscina 1')]")
    public AndroidElement xpathPiscina;

    public PiscinaPage clickPiscina(String nombrePiscina) {
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[(@text='" + nombrePiscina + "')]");
        element.click();
        //click(xpathPiscina);

        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[(@text='Salinidad')]")
    public AndroidElement xpathSalinidad;

    public PiscinaPage clickSalinidad() {
        click(xpathSalinidad);
        return this;
    }
    public PiscinaPage clickParametro(String nombreParametro) {
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[(@text='"+nombreParametro+"')]");
        element.click();

        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.Button[(@text='2')]")
    public AndroidElement xpathDigito2;

    public PiscinaPage clickDigito2() {
        click(xpathDigito2);
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.Button[(@text='9')]")
    public AndroidElement xpathDigito9;

    public PiscinaPage clickDigito9() {
        click(xpathDigito9);
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.Button[(@text='Ingresar')]")
    public AndroidElement xpathIngresar;

    public PiscinaPage clickBtnIngresar() {
        click(xpathIngresar);
        return this;
    }

    @AndroidFindBy(xpath = "//android.widget.Button[(@text='Volver a parámetros')]")
    public AndroidElement xpathVolverParametros;

    public PiscinaPage clickBtnVolverParametros() {
        click(xpathVolverParametros);
        return this;
    }

    //parametros
    @AndroidFindBy(xpath = "//android.widget.TextView[(@text='Este dato ya fue ')]")
    public AndroidElement xpathEsteDatoYaFue;

    @AndroidFindBy(xpath = "//android.widget.Button[(@id='btnBackParameters')]")
    public AndroidElement xpathBtnVolverParametros;





}
