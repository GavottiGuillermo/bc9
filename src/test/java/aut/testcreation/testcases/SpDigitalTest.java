package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SpDigitalTest extends SeleniumTestBase {

    WebDriver driver;

    @Test
    public void spDigitalMsjBusqueda() throws InterruptedException {

        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.spdigital.cl/");

        By buscador = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/span[1]/form/div/input");
        By btnBuscar = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[2]/div/span[1]/form/div/button");


        WebElement webElementBuscar = driver.findElement(buscador);
        WebElement webElementBtnBuscar = driver.findElement(btnBuscar);


        webElementBuscar.sendKeys("jdjghah");
        Thread.sleep(5000);
        webElementBtnBuscar.click();
        Thread.sleep(10000);


        By msjRespuesta = By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div[4]/section[1]/div/div[2]/div[2]/span[1]");
        WebElement webElementMsjRespuesta = driver.findElement(msjRespuesta);
        String respuesta = webElementMsjRespuesta.getText();

        Assertions.assertEquals("0 - 0 de 0 productos para tu búsqueda: \"jdjghah\"",respuesta);

    }
}
