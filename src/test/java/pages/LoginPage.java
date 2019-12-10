package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/etUser")
    public AndroidElement xpathTextUsuario;

    public LoginPage esperarTxtUsuario() {
        wait_element(xpathTextUsuario);
        return this;
    }


    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/etUser")
    public AndroidElement idUsuario;

    public LoginPage tapUsuario() {
        click(idUsuario);
        return this;
    }

    public LoginPage sendUsuario(String usuario) {
        sendKeys(idUsuario,usuario);
        return this;
    }


    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/etPass")
    public AndroidElement idPassword;

    public LoginPage tapPassword() {
        click(idPassword);
        return this;
    }

    public LoginPage sendPassword(String password) {
        sendKeys(idPassword,password);
        return this;
    }



    @AndroidFindBy(id = "com.alicorp.android.nicosoftasesoria:id/btnLogin")
    public AndroidElement idBtnIngresar;

    public LoginPage tapBtnIngresar() {
        click(idBtnIngresar);
        return this;
    }

}
