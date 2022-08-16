package desafio.grupo2.rumbo.testcreation.testcases;

import desafio.grupo2.rumbo.testcreation.pages.RumboEsHomePage;
import desafio.grupo2.rumbo.testcreation.pages.RumboEsTrenesBusquedaPage;
import desafio.grupo2.rumbo.testcreation.pages.RumboEsTrenesPage;
import framework.engine.selenium.DriverFactory;
import framework.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CP001_Trenes extends SeleniumTestBase {

    RumboEsHomePage rumboEsHomePage;
    RumboEsTrenesPage rumboEsTrenesPage;

    RumboEsTrenesBusquedaPage rumboEsTrenesBusquedaPage;

    @ParameterizedTest
    @MethodSource
    @Description("Test de prueba")
    void CP001_BusquedadeTren(String Origen,String Destino, String esperado) throws InterruptedException {

        rumboEsHomePage = new RumboEsHomePage(DriverFactory.getDriver());
        rumboEsHomePage.despegarARumbos();
        rumboEsHomePage.aceptarCookies();
        rumboEsHomePage.irATrenes();


        rumboEsTrenesPage = new RumboEsTrenesPage(DriverFactory.getDriver());
        rumboEsTrenesPage.seleccionarIda();
        rumboEsTrenesPage.ingresarOrigen(Origen);
        rumboEsTrenesPage.ingresarDestino(Destino);
        rumboEsTrenesPage.seleccionarCalendario();
        rumboEsTrenesPage.establecerBusqueda();

        rumboEsTrenesBusquedaPage = new RumboEsTrenesBusquedaPage(DriverFactory.getDriver());
        String Resultado = rumboEsTrenesBusquedaPage.obtenerRutaOri() + " - " + rumboEsTrenesBusquedaPage.obtenerRutaDes();

        Assertions.assertEquals(esperado,Resultado);


    }
    static Stream<Arguments>CP001_BusquedadeTren(){
        return Stream.of(

                Arguments.arguments("Madrid","Barcelona", "XOC - YJB")
        );
    }
}