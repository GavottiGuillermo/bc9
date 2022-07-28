package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import static aut.engine.utils.Constants.BASE_URL_AUT;

public class TestDemo extends SeleniumTestBase {

    WebDriver driver;

    @Test
    @Description("Test creado para bootcamp 9 tsoft")
    public void testDemo() throws InterruptedException {
        //inicializacion
        driver = DriverFactory.getDriver(); // crea el browser de la prueba
        driver.navigate().to(BASE_URL_AUT);

        //Seleccionar elementos de la pagina click










        //Acciones del browser -- Como movernos

       /* driver.get(BASE_URL_AUT);//google.com
        String ventanaUno = driver.getWindowHandle(); //id de la ventana

        driver.switchTo().newWindow(WindowType.WINDOW);
        String ventanaDos = driver.getWindowHandle();// veo el id de la ventana

        driver.switchTo().newWindow(WindowType.TAB);
        String pestanha = driver.getWindowHandle();//veo el id del tab
        driver.get(BASE_URL_AUT);

        driver.switchTo().window(ventanaUno);
        driver.get(BASE_URL_AUT);

        driver.switchTo().window(ventanaDos);
        driver.get(BASE_URL_AUT);*/






        //Acciones basicas.
/*      String nombreUrlActual = driver.getCurrentUrl();
        String tituloWeb= driver.getTitle();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);
        Thread.sleep(3000);
        driver.navigate().to("https://selenium.dev");
        Thread.sleep(3000);
        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb= driver.getTitle();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);

        //Browser :: Back - Fordward - Refresh
        driver.navigate().back();
        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb= driver.getTitle();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);


        driver.navigate().forward();
        nombreUrlActual = driver.getCurrentUrl();
        tituloWeb= driver.getTitle();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);

        driver.navigate().refresh(); //F5

        //Switch windows
        String originalWindow = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().window(originalWindow);
        nombreUrlActual = driver.getCurrentUrl();
        System.out.println("Me encuentro en: " + nombreUrlActual + " y su titulo es: " + tituloWeb);
        Thread.sleep(3000);


        driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.switchTo().frame("packageFrame");
        driver.findElement(By.linkText("Alert")).click();
        Thread.sleep(5000);
        driver.switchTo().defaultContent();
*/

        /*//Dimension del browser
        Dimension altoAncho = driver.manage().window().getSize();
        int alto = altoAncho.getHeight();
        int ancho = altoAncho.getWidth();

        driver.manage().window().setSize(new Dimension(800,600);

        //Posicionamiento del browser.
        int posicionX = driver.manage().window().getPosition().getX();
        int posicionY = driver.manage().window().getPosition().getY();

        Point posicionDelDriver = driver.manage().window().getPosition();
        posicionX = driver.manage().window().getPosition().getX();
        posicionY = driver.manage().window().getPosition().getY();

        driver.manage().window().setPosition(new Point(0,0));*/

        Assertions.assertTrue(true);


    }
}