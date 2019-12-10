package pages;

import base.BasePage;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AnalisisPage extends BasePage {
    public AnalisisPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/tvFarmName")
    public AndroidElement xpathTextFinca;

    public AnalisisPage esperarTxtFinca() {
        wait_element(xpathTextFinca);
        return this;
    }

    public AnalisisPage tapFinca(String finca) {
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[(@text='" + finca + "')]");
        element.click();
        return this;
    }

    public AnalisisPage tapPiscina(String piscina) {
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[(@text='Piscina " + piscina + "')]");
        element.click();
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/btnNext")
    public AndroidElement idBtnSiguiente;

    public AnalisisPage tapSiguiente() {
        click(idBtnSiguiente);
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/etCultivation")
    public AndroidElement idTxtDiaCultivo;

    public AnalisisPage setDiaCultivo(String diaCultivo) {
        wait_element(idTxtDiaCultivo);
        click(idTxtDiaCultivo);
        sendKeys(idTxtDiaCultivo, diaCultivo);
        return this;
    }


    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/etWeight")
    public AndroidElement idTxtPeso;

    public AnalisisPage setPeso(String peso) {
        wait_element(idTxtPeso);
        click(idTxtPeso);
        sendKeys(idTxtPeso, peso);
        return this;
    }


    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/tvHintCultivationStage")
    public AndroidElement idEtapaCultivo;

    public AnalisisPage setEtapaCultivo(String etapaCultivo) throws InterruptedException {
        wait_element(idEtapaCultivo);
        click(idEtapaCultivo);
        Thread.sleep(1000);
        setEtapa(etapaCultivo);
        return this;
    }

    public AnalisisPage setEtapa(String etapa) {
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.CheckedTextView[(@text='" + etapa + "')]");
        element.click();
        return this;
    }


    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/rbPlGrams")
    public AndroidElement idUnidadMedida;

    public AnalisisPage setUnidadMedida(String unidadMedida) throws InterruptedException {
        if (unidadMedida.equalsIgnoreCase("pl/g")) {
            wait_element(idUnidadMedida);
            click(idUnidadMedida);
            Thread.sleep(1000);
        }
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/etPlantingWeight")
    public AndroidElement idTxtPesoSiembra;

    public AnalisisPage setPesoSiembra(String pesoSiembra) {
        click(idTxtPesoSiembra);
        sendKeys(idTxtPesoSiembra, pesoSiembra);
        return this;
    }


    public AnalisisPage tapOrgano(String organo) {
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[(@text='" + organo + "')]");
        element.click();
        return this;
    }

    public AnalisisPage tapNombreEstudio(String nombreEstudio) {
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[(@text='" + nombreEstudio + "')]");
        element.click();
        return this;
    }

    //
    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/btnAddG1")
    public AndroidElement idBtnAddG1;

    public AnalisisPage tapAddG1(int taps) {
        tapGravedad(idBtnAddG1, taps);
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/btnAddG2")
    public AndroidElement idBtnAddG2;

    public AnalisisPage tapAddG2(int taps) {
        tapGravedad(idBtnAddG2, taps);
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/btnAddG3")
    public AndroidElement idBtnAddG3;

    public AnalisisPage tapAddG3(int taps) {
        tapGravedad(idBtnAddG3, taps);
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/btnAddG4")
    public AndroidElement idBtnAddG4;

    public AnalisisPage tapAddG4(int taps) {
        tapGravedad(idBtnAddG4, taps);
        return this;
    }

    public void tapGravedad(AndroidElement element, int value) {
        for (int i = 0; i < value; i++) {
            element.click();
        }
    }


    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/btnAddComment")
    public AndroidElement idBtnComentario;

    public AnalisisPage tapComentario(String comentario) throws InterruptedException {
        click(idBtnComentario);
        Thread.sleep(1000);
        tapTxtComentario(comentario);
        return this;
    }

    public AnalisisPage tapTxtComentario(String comentario) throws InterruptedException {
        AndroidElement element = (AndroidElement) driver.findElementById("com.alicorp.android.nicosoftasesoria:id/etComments");
        element.click();
        element.sendKeys(comentario);
        tapGrabarComentario();
        return this;
    }

    //
    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/tvSaveComment")
    public AndroidElement idGrabarComentario;

    public AnalisisPage tapGrabarComentario() throws InterruptedException {
        click(idGrabarComentario);
        return this;
    }
    // Lípidos
    public AnalisisPage tapLipidos() {
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[(@text='Lípidos')]");
        element.click();
        return this;
    }

    public AnalisisPage tapLipidosValue(String porcentajeLipidos) {
        tapLipidos();
        AndroidElement element = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[(@text='" + porcentajeLipidos + "')]");
        element.click();
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/btnTakePhoto")
    public AndroidElement idBtnTomarFoto;

    public AnalisisPage tabBtnTomarFoto() {
        wait_element(idBtnTomarFoto);
        click(idBtnTomarFoto);
        tabBtnAllow();
        tabBtnShutter();
        tabBtnDone();
        return this;
    }

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    public AndroidElement idBtnAllow;

    public AnalisisPage tabBtnAllow() {
        wait_element(idBtnAllow);
        click(idBtnAllow);
        return this;
    }


    @AndroidFindBy(id = "com.android.camera2:id/shutter_button")
    public AndroidElement idBtnShutter;
    public AnalisisPage tabBtnShutter() {
        wait_element(idBtnShutter);
        click(idBtnShutter);
        click(idBtnShutter);
        return this;
    }


    @AndroidFindBy(id = "com.android.camera2:id/done_button")
    public AndroidElement idBtnDone;
    public AnalisisPage tabBtnDone() {
        wait_element(idBtnDone);
        click(idBtnDone);
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/ivPic")
    public AndroidElement idBtnTinyPhoto;
    public AnalisisPage tabImgTinyPhoto() {
        wait_element(idBtnTinyPhoto);
        click(idBtnTinyPhoto);
        return this;
    }


    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/ivArrowHep")
    public AndroidElement idBtnCheckOrgano;
    public AnalisisPage tabImgCheckOrgano() {
        wait_element(idBtnCheckOrgano);
        click(idBtnCheckOrgano);
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/ivCommentGills")
    public AndroidElement idBtnCheckComentario;
    public AnalisisPage tabImgCheckComentario() {
        wait_element(idBtnCheckComentario);
        click(idBtnCheckComentario);
        return this;
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/ivCheck")
    public AndroidElement idImgFin;
    public AnalisisPage tabImgFin() {
        wait_element(idImgFin);
        click(idImgFin);
        return this;
    }


    public AnalisisPage swipeBtnFinalizar() {
       swipeToButton();
        return this;
    }
}
