package desafio.grupo2.rumbo.testcreation.pages;

import framework.engine.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RumboVuelosSecurePage extends SeleniumWrapper {
    public RumboVuelosSecurePage(WebDriver driver) {
        super(driver);
    }

    By botonElegirClassic = By.xpath("//div[text()=\"Elegir Classic\"]");



    public void elegirClassic(){
        click(botonElegirClassic);
    }

    public void rellenarDatosPersonales(){
        By inputNombre = By.xpath("//input[@data-test=\"input-name\"]");
        By inputApellido = By.xpath("//input[@data-test=\"input-surname\"]");
        By inputEmail= By.xpath("//input[@id=\"contact-email\"]");
        By botonDesplegarPrefijos = By.xpath("//div[@class=\"selected-flag\"]");
        By codigoAreaArg = By.xpath("//li[@data-country-code=\"ar\"]");
        By inputTelefono = By.xpath("//input[@data-test=\"input-phone\"]");
        By inputDireccionPostal = By.xpath("//input[@data-test=\"input-address\"]");
        By inputNumCalle= By.xpath("//input[@data-test=\"input-houseNumber\"]");
        By inputCodigoPostal = By.xpath("//input[@data-test=\"input-postCode\"]");
        By inputCiudad = By.xpath("//input[@data-test=\"input-city\"]");
        By botonDesplegarPais= By.xpath("//div[@class=\"form-control text-input flag-dropdown\"]");
        By paisArg = By.xpath("//li[@data-flag-key=\"flag_no_13\"]");

        write("Lucas",inputNombre);
        write("Gonzalez",inputApellido);
        write("lucasgonz98@g",inputEmail);
        sendKeys(Keys.TAB,inputEmail);
/*        click(inputEmail);
        click(botonDesplegarPrefijos);
        click(botonDesplegarPrefijos);
        click(codigoAreaArg);*/
        write("3804228169",inputTelefono);
        sendKeys(Keys.TAB,inputTelefono);
/*        write("Felipe II",inputDireccionPostal);
        write("125",inputNumCalle);
        write("5300",inputCodigoPostal);
        write("La Rioja",inputCiudad);
        click(botonDesplegarPais);
        click(paisArg);*/


    }


    public void rellenarQuienViaja(){
        By botonSr = By.xpath("(//div[@class=\"radio radio--middle \"])[1]");
        By inputNom = By.xpath("//input[@data-test=\"input-groups.1.travellers.1.name\"] ");
        By inputApe= By.xpath("//input[@data-test=\"input-groups.1.travellers.1.surname\"]");
        By inputDiaNacimiento = By.xpath("//input[@data-test=\"input-groups.1.travellers.1.dateOfBirth-day\"] ");
        By botonDesplegarMeses = By.xpath("//select[@class=\"form-control select-input date__field\"]");
        By seleccionMesNacimiento= By.xpath("//option[@value=\"11\"]");
        By inputAnoNacimiento = By.xpath("//input[@data-test=\"input-groups.1.travellers.1.dateOfBirth-year\"]");
        click(botonSr);
/*        write("Lucas",inputNom);
        write("Gonzalez",inputApe);*/
        write("09",inputDiaNacimiento);
        click(botonDesplegarMeses);
        click(seleccionMesNacimiento);
        write("1998",inputAnoNacimiento);

    }

    public void opcionesViaje(){
/*        By botonSinEquipajeIda = By.xpath("(//div[@class=\"radio radio--middle \"])[3]");
        By botonSinEquipajeVuelta = By.xpath("(//div[@class=\"radio radio--middle \"])[17]");*/
        By checkBoxProteger = By.xpath("//div[@class=\"checkbox\"]");
        By BotonSiguiente = By.xpath("//button[@class=\"btn btn-cta lead-generation-submit__btn \"]");

/*        click(botonSinEquipajeIda);
        click(botonSinEquipajeVuelta);*/
        click(checkBoxProteger);
        click(BotonSiguiente);
    }

    public void servicios(){
        By radioButtonSinPlus = By.xpath("//span[@data-test=\"radio-membershipProposal-STD-custom-radio\"]");
        By radioButtonFullFlex = By.xpath("(//div[@class=\"insurance__expandable-upper-box\"])[1]");

        click(radioButtonSinPlus);
        click(radioButtonFullFlex);

    }

    public void rellanarPago(){
        By inputTitularTarjeta = By.xpath("//input[@data-test=\"input-creditCard.cardHolder\"]");
        By inputNumeroTarjeta = By.xpath("//input[@data-test=\"input-creditCard.cardNumber\"] ");
        By inputMesExpiracion = By.xpath("(//input[@data-test=\"input-creditCard.expirationDate\"])[1]");
        By inputAnoExpiracion = By.xpath("(//input[@data-test=\"input-creditCard.expirationDate\"])[2]");
        By inputCVV = By.xpath("//input[@data-test=\"input-creditCard.cvv\"]");

        write("Lucas",inputTitularTarjeta);
        write("125785",inputNumeroTarjeta);
        write("11",inputMesExpiracion);
        write("27",inputAnoExpiracion);
        write("248",inputCVV);
    }

}