package stepdefs;

import base.SetUp;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import pages.AnalisisPage;
import pages.LoginPage;
import pages.PiscinaPage;
import pages.ScreenShots;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

public class ATSStepsDef {

    SetUp objSetup = new SetUp();
    Scenario scenario;
    String parametro = "";

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^ATS ingresa a formulario Login y selecciona campo Usuario$")
    public void ats_ingresa_a_formulario_Login_y_selecciona_campo_Usuario() throws Throwable {
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        ScreenShots objScreenShots = new ScreenShots();
        try {
            objLoginPage.esperarTxtUsuario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Falló ");
            Assert.fail();
        }
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS ingresa su correo \"([^\"]*)\"$")
    public void ats_ingresa_su_correo(String arg1) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        objLoginPage.sendUsuario(arg1);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS selecciona campo Contraseña$")
    public void ats_selecciona_campo_Contraseña() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        objLoginPage.tapPassword();
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS ingresa su clave \"([^\"]*)\"$")
    public void ats_ingresa_su_clave(String arg1) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        objLoginPage.sendPassword(arg1);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS selecciona botón Ingresar$")
    public void ats_selecciona_botón_Ingresar() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        objLoginPage.tapBtnIngresar();

        Thread.sleep(5000);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS selecciona la finca \"([^\"]*)\"$")
    public void ats_selecciona_la_finca(String finca) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.esperarTxtFinca();
        analisis.tapFinca(finca);

        Thread.sleep(5000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS visualiza todas las piscinas de la finca seleccionada$")
    public void ats_visualiza_todas_las_piscinas_de_la_finca_seleccionada() throws Throwable {

    }

    @When("^ATS elige la piscina \"([^\"]*)\"$")
    public void ats_elige_la_piscina(String piscina) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapPiscina(piscina);

        Thread.sleep(5000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^se activa el boton Siguiente$")
    public void se_activa_el_boton_Siguiente() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapSiguiente();
        Thread.sleep(5000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS visualiza el formulario Completa los datos$")
    public void ats_visualiza_el_formulario_Completa_los_datos() throws Throwable {

    }

    @When("^ATS ingresa los dias de cultivo \"([^\"]*)\"$")
    public void ats_ingresa_los_dias_de_cultivo(String diaCultivo) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.setDiaCultivo(diaCultivo);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS ingresa el peso \"([^\"]*)\" en gramos$")
    public void ats_ingresa_el_peso_en_gramos(String peso) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.setPeso(peso);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS selecciona etapa de cultivo \"([^\"]*)\"$")
    public void ats_selecciona_etapa_de_cultivo(String etapaCultivo) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.setEtapaCultivo(etapaCultivo);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS elige la unidad de medida \"([^\"]*)\"$")
    public void ats_elige_la_unidad_de_medida(String unidadMedida) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.setUnidadMedida(unidadMedida);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS ingresa el peso de siembra \"([^\"]*)\"$")
    public void ats_ingresa_el_peso_de_siembra(String pesoSiembra) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.setPesoSiembra(pesoSiembra);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS presiona el boton Empezar$")
    public void ats_presiona_el_boton_Empezar() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapSiguiente();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS visualiza el formulario de analisis de Patologia$")
    public void ats_visualiza_el_formulario_de_analisis_de_Patologia() throws Throwable {

    }

    @When("^ATS ingresa analisis de organo \"([^\"]*)\"$")
    public void ats_ingresa_analisis_de_organo(String organo) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapOrgano(organo);
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS ingresa datos del estudio de \"([^\"]*)\"$")
    public void ats_ingresa_datos_del_estudio_de(String nombreEstudio) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapNombreEstudio(nombreEstudio);
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS ingresa valor de G(\\d+) \"([^\"]*)\"$")
    public void ats_ingresa_valor_de_G(int grado, String valor) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        int value = Integer.parseInt(valor);
        String sgrado = grado + "";
        switch (sgrado) {
            case "1":
                analisis.tapAddG1(value);
                break;
            case "2":
                analisis.tapAddG2(value);
                break;
            case "3":
                analisis.tapAddG3(value);
                break;
            case "4":
                analisis.tapAddG4(value);
                break;

        }


        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^presiona el nombre del estudio \"([^\"]*)\" para minimizarlo$")
    public void presiona_el_nombre_del_estudio_para_minimizarlo(String nombreEstudio) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapNombreEstudio(nombreEstudio);
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS agrega comentario del organo \"([^\"]*)\"$")
    public void ats_agrega_comentario_del_organo(String comentario) throws Throwable {

        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapComentario(comentario);
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS ingresa los datos de lipidos \"([^\"]*)\"$")
    public void ats_ingresa_los_datos_de_lipidos(String porcLipidos) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapLipidosValue(porcLipidos);
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @When("^ATS presiona el boton Finalizar \"([^\"]*)\"$")
    public void ats_presiona_el_boton_Finalizar(String arg1) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tapSiguiente();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS visualiza el mensaje de confirmacion$")
    public void ats_visualiza_el_mensaje_de_confirmacion() throws Throwable {

    }

    @Then("^ATS presiona el boton Tomar foto$")
    public void ats_presiona_el_boton_Tomar_foto() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tabBtnTomarFoto();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^retornara al formulario anterior con la foto capturada en miniatura$")
    public void retornara_al_formulario_anterior_con_la_foto_capturada_en_miniatura() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tabImgTinyPhoto();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS visualiza el formulario de analisis de Patologia con los simbolos de comentario y finalizado$")
    public void ats_visualiza_el_formulario_de_analisis_de_Patologia_con_los_simbolos_de_comentario_y_finalizado() throws Throwable {
        /*ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tabImgCheckComentario();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();*/
    }

    @When("^ATS desliza el boton para finalizar$")
    public void ats_desliza_el_boton_para_finalizar() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.swipeBtnFinalizar();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^ATS deberia visualizar la pantalla de analisis patologico terminado$")
    public void ats_deberia_visualizar_la_pantalla_de_analisis_patologico_terminado() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        AnalisisPage analisis = new AnalisisPage(SetUp.getDriver());
        analisis.tabImgFin();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    //=================
    @Given("^Parametrista ingresa a formulario Login y selecciona campo Usuario$")
    public void parametrista_ingresa_a_formulario_Login_y_selecciona_campo_Usuario() throws Throwable {
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        ScreenShots objScreenShots = new ScreenShots();
        try {
            objLoginPage.esperarTxtUsuario();
            //objLoginPage.tapUsuario();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Falló ");
            Assert.fail();
        }
        objScreenShots.capturar_pantalla();
    }

    @Then("^Parametrista ingresa su correo \"([^\"]*)\"$")
    public void parametrista_ingresa_su_correo(String arg1) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        objLoginPage.sendUsuario(arg1);
        objScreenShots.capturar_pantalla();
    }

    @When("^Parametrista selecciona campo Contraseña$")
    public void parametrista_selecciona_campo_Contraseña() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        objLoginPage.tapPassword();
        objScreenShots.capturar_pantalla();
    }

    @Then("^Parametrista ingresa su clave \"([^\"]*)\"$")
    public void parametrista_ingresa_su_clave(String arg1) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        objLoginPage.sendPassword(arg1);
        objScreenShots.capturar_pantalla();
    }

    @Then("^Parametrista selecciona botón Ingresar$")
    public void parametrista_selecciona_botón_Ingresar() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        LoginPage objLoginPage = new LoginPage(SetUp.getDriver());
        objLoginPage.tapBtnIngresar();

        Thread.sleep(5000);
        objScreenShots.capturar_pantalla();
    }

    @Then("^Parametrista visualiza la lista de piscinas$")
    public void parametrista_visualiza_la_lista_de_piscinas() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        objScreenShots.capturar_pantalla();
    }

    @When("^Parametrista selecciona la piscina \"([^\"]*)\"$")
    public void parametrista_selecciona_la_piscina(String arg1) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        PiscinaPage objPiscina = new PiscinaPage(SetUp.getDriver());
        objPiscina.clickPiscina(arg1);
        Thread.sleep(5000);
        objScreenShots.capturar_pantalla();
    }

    @When("^Parametrista selecciona parametro \"([^\"]*)\" y valor (\\d+)$")
    public void parametrista_selecciona_parametro_y_valor(String parametro, int arg2) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        PiscinaPage objPiscina = new PiscinaPage(SetUp.getDriver());
        objPiscina.clickParametro(parametro);
        Thread.sleep(1000);

        objScreenShots.capturar_pantalla();
    }

    @When("^Parametrista selecciona parametro \"([^\"]*)\"$")
    public void parametrista_selecciona_parametro(String parametro) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        PiscinaPage objPiscina = new PiscinaPage(SetUp.getDriver());
        objPiscina.clickParametro(parametro);
        Thread.sleep(1000);

        objScreenShots.capturar_pantalla();
    }

    @When("^Parametrista ingresa el valor (\\d+)$")
    public void parametrista_ingresa_el_valor(int arg1) throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        PiscinaPage objPiscina = new PiscinaPage(SetUp.getDriver());
        String valorParametro = "";
        switch (parametro) {
            case "Oxígeno Noche":
                valorParametro = "24";
                break;
            case "Temperatura Noche":
                valorParametro = "24";
                break;
            case "Oxígeno Tarde":
                valorParametro = "24";
                break;
            case "Temperatura Tarde":
                valorParametro = "24";
                break;
            case "Oxígeno Mañana":
                valorParametro = "24";
                break;
            case "Temperatura Mañana":
                valorParametro = "24";
                break;
            case "Salinidad":
                valorParametro = "24";
                break;
            case "Transparencia":
                valorParametro = "24";
                break;
            case "PH":
                valorParametro = "24";
                break;
            case "Alcalinidad":
                valorParametro = "24";
                break;
        }
        objPiscina.clickDigito2();
        Thread.sleep(1000);
        objPiscina.clickDigito9();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @When("^Paramaetrista presiona boton Ingresar$")
    public void paramaetrista_presiona_boton_Ingresar() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        PiscinaPage objPiscina = new PiscinaPage(SetUp.getDriver());
        objPiscina.clickBtnIngresar();
        Thread.sleep(1000);
        objScreenShots.capturar_pantalla();
    }

    @When("^Parametrista selecciona boton volver a parametros$")
    public void parametrista_selecciona_boton_volver_a_parametros() throws Throwable {
        ScreenShots objScreenShots = new ScreenShots();
        PiscinaPage objPiscina = new PiscinaPage(SetUp.getDriver());
        //objPiscina.clickBtnVolverParametros();
        Thread.sleep(8000);
        objScreenShots.capturar_pantalla();
    }

}
