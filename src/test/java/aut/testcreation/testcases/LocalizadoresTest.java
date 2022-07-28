package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class LocalizadoresTest extends SeleniumTestBase {

    WebDriver driver;

    By btnEnviarA = By.xpath("/html/body/header/div/div[2]/ul/li[1]/a");

    By popElegiDondeRecibir = By.xpath("//*[@id=\"root-app\"]");
    By cerrarPopElegi = By.className("");
    By btnEntenido = By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");

    @Test
    void localizandoElementos() throws InterruptedException {

        driver = DriverFactory.getDriver();
        driver.navigate().to(BASE_URL_AUT);

        WebElement webElementBtnEntendido = driver.findElement(btnEntenido);
        if (webElementBtnEntendido.isEnabled()){
            webElementBtnEntendido.click();
        }

        WebElement webElementbtnEnviarA = driver.findElement(btnEnviarA);
        if (webElementbtnEnviarA.isEnabled()){
            String text = webElementbtnEnviarA.getText();
            System.out.println(text);
            webElementbtnEnviarA.click();
        }

        if (driver.findElement(cerrarPopElegi).isEnabled()){
            WebElement webElementCerrarPop = driver.findElement(cerrarPopElegi);
            webElementCerrarPop.click();
        }
        Thread.sleep(5000);
        driver.quit();



    }

}
