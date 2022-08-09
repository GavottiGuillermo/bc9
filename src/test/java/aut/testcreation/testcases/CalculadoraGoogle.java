package aut.testcreation.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class CalculadoraGoogle {

    static WebDriver driver;

    @BeforeAll
    static void init() {
        WebDriverManager.chromedriver().setup();


    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //Espera implicita -> antes de enviar el timeOut Exception
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
    }

    @Test
    void CalculadoraTest(){

        int n1=2;
        int n2=2;
        String operacion="+";
        String resultadoFuncion = Integer.toString(Calcular(n1,n2,operacion));

        driver.navigate().to("https://www.google.com/search?q=calculadora&rlz=1C1GCEA_enAR1013AR1013&sxsrf=ALiCzsYKK7gRgyP7cQTxK6PxMi51WhZJ1w%3A1659542794722&ei=Cp3qYpDNK7fk1sQPzt292Aw&ved=0ahUKEwiQ-pLWhqv5AhU3spUCHc5uD8sQ4dUDCA4&oq=calculadora&gs_lcp=Cgdnd3Mtd2l6EAwyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAEEcQsAMyBwgAELADEEMyBwgAELADEENKBAhBGABKBAhGGABQAFgAYKQdaAFwAXgAgAEAiAEAkgEAmAEAyAEKwAEB&sclient=gws-wiz");
        WebElement panelNumeros = driver.findElement(By.className("ElumCf"));
        List<WebElement> filas = panelNumeros.findElements(By.tagName("tr"));


        String nro1=Integer.toString(n1);
        buscarBoton(filas,nro1);
        buscarBoton(filas,operacion);
        String nro2=Integer.toString(n2);
        buscarBoton(filas,nro2);
        String resultado="=";
        buscarBoton(filas,resultado);

        String resultadoGoogle = driver.findElement(By.xpath("//span[@id='cwos']")).getText();

        Assertions.assertEquals(resultadoFuncion,resultadoGoogle);

    }

    private void buscarBoton(List<WebElement> filas, String boton) {
        for(int i = 0; i< filas.size(); i++){
            List<WebElement> columnas = filas.get(i).findElements(By.tagName("td"));
            for (int j=0; j < columnas.size(); j++){

                if(columnas.get(j).getText().equals(boton)){
                    columnas.get(j).click();
                }
            }
        }
    }

    private int Calcular(int nro1, int nro2, String operador) {

        switch (operador){

            case("+"):
                return nro1 + nro2;
            case("-"):
                return nro1 - nro2;
            case("*"):
                return nro1 * nro2;
            case("/"):
                return nro1 / nro2;

            default: return 0;
        }

    }

}


