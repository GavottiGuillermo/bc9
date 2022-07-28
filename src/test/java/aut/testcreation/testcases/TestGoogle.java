package aut.testcreation.testcases;

import aut.engine.selenium.DriverFactory;
import aut.engine.selenium.SeleniumTestBase;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

public class TestGoogle extends SeleniumTestBase {
    WebDriver driver;

    @Test
    @Description("Test para practicar selenium en google")
    public void testGoogle() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.navigate().to("https://www.google.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        //respuesta
        String url = driver.getCurrentUrl();
        String title = driver.getTitle();
        String pageSource = driver.getPageSource();
        String handle= driver.getWindowHandle();

        //find
        //driver.findElement(By.className("gLFyf")).sendKeys("zapatos");
        driver.findElement(By.tagName("input")).sendKeys("poleras");
        //driver.findElement(By.className("RNNXgb")).findElement(By.tagName("input")).sendKeys("poleras");
        driver.findElement(By.name("btnK")).click();

        //navegar
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.navigate().to("https://translate.google.cl");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[1]/span/span/div/textarea")).sendKeys("Hello World");
        Thread.sleep(5000);
        driver.manage().window().setSize(new Dimension(800,600));
        Thread.sleep(2000);
        driver.manage().window().setPosition(new Point(400,40));
        Thread.sleep(3000);
        //driver.close();//cerrar todas las pestañas del navegador
        driver.quit();//cerrar de forma segura

        Assertions.assertTrue(true);
    }
}
