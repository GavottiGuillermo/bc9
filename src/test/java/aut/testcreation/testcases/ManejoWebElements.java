package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ManejoWebElements {

    static WebDriver driver;
    By dropDownLocator = By.id("dropdown");
    By check1 = By.xpath("//form[@id='checkboxes']/input[1]");
    By check2 = By.xpath("//form[@id='checkboxes']/input[2]");

    By btnEnabledLocator = By.xpath("//*[@id=\"ui-id-3\"]/a");
    By btnDownloadLocator = By.xpath("//*[@id=\"ui-id-4\"]/a");

    By btnPDFLocator = By.xpath("//*[@id=\"ui-id-5\"]/a");

    By iframeText = By.xpath("//*[@id=\"tinymce\"]/p");

    By btnDue = By.xpath("//*[@id=\"table1\"]/thead/tr/th[4]/span");

    By nombre = By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[1]");

    By apellido = By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[2]");

    By deuda = By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[4]");








    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();


    }

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Espera implicita -> antes de enviar el timeOut Exception
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    //dropdown
    @Test
    void dropdown(){
        System.out.println("Test Dropdown");
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
        //WebElement
        WebElement dropdown = driver.findElement(dropDownLocator);
        //Select -> select
        Select select = new Select(dropdown);
        select.selectByValue("1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
    }

    @Test
    void checkbox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //checkbox -> input
        WebElement checkbox1 = driver.findElement(check1);
        WebElement checkbox2 = driver.findElement(check2);
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        if(checkbox2.isSelected()){
            checkbox2.click();
        }

    }

    @Test
    void menuDinamico() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu");
        WebElement btnEnabled = driver.findElement(btnEnabledLocator);
        WebElement btnDownload = driver.findElement(btnDownloadLocator);
        WebElement btnPDF = driver.findElement(btnPDFLocator);


        //Espera Explicita
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));


        if(btnPDF.isDisplayed()){
            btnPDF.click();
        }

        if(btnDownload.isDisplayed()){
            btnDownload.click();
        }

        if(btnEnabled.isDisplayed()){
            btnEnabled.click();
            Thread.sleep(1000);
            btnDownload.click();
            Thread.sleep(1000);
            btnPDF.click();
            Thread.sleep(1000);
        }

    }

    @Test
    void iframes(){

        driver.navigate().to("https://the-internet.herokuapp.com/tinymce");
        //Traernos todos los iframes de la pagina
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        driver.switchTo().frame(iframes.get(0));
        WebElement iframeTextElement = driver.findElement(iframeText);
        iframeTextElement.clear();
        iframeTextElement.sendKeys("Hola estoy enviando informacion desde el driver");

    }

    @Test
    void webTables(){

        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        //traer elementos de la tabla
        List<WebElement> webTable = driver.findElements(By.id("table1"));

        //Cuantas columnas tiene la tabla?
        List<WebElement> columnas = webTable.get(0).findElement(By.tagName("thead")).findElements(By.tagName("th"));

        for (int i=0; i<columnas.size(); i++){

            String text = columnas.get(i).getText();
            if(text.equals("Due")){
                columnas.get(i).click();
                columnas.get(i).click();
            }

        }
        List<WebElement> filas = webTable.get(0).findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        WebElement ElemNombre= filas.get(0).findElement(nombre);
        WebElement ElemApellido = filas.get(0).findElement(apellido);
        WebElement ElemDue = filas.get(0).findElement(deuda);


        String nombreTexto = ElemNombre.getText();
        String apellidoTexto = ElemApellido.getText();
        String dueTexto = ElemDue.getText();


        System.out.println("El cliente con la deuda mas alta es " + nombreTexto + " " + apellidoTexto + " la deuda es " + dueTexto);




    }

    @AfterAll
    static void closeDriver(){
        driver.quit();
     }




}
