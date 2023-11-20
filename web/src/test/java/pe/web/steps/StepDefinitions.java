package pe.web.steps;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinitions {
	WebDriver driver;
	
	@Given("^que abro el navegador$")
    public void abrirNavegador() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
	
	@When("^ingreso a \"([^\"]*)\"$")
    public void ingresarAPagina(String url) {
        driver.get(url);
    }
/*
    @And("^selecciono \"([^\"]*)\" en la página principal$")
    public void seleccionarSignUp(String opcion) {
        WebElement signUpLink = driver.findElement(By.id("signup"));
        signUpLink.click();
    }

    @And("^completo el formulario con nombre \"([^\"]*)\", email \"([^\"]*)\" y contraseña \"([^\"]*)\"$")
    public void completarFormulario(String nombre, String email, String contraseña) {
        WebElement nameInput = driver.findElement(By.id("sign-username"));
        nameInput.sendKeys(nombre);

        WebElement emailInput = driver.findElement(By.id("sign-email"));
        emailInput.sendKeys(email);

        WebElement passwordInput = driver.findElement(By.id("sign-password"));
        passwordInput.sendKeys(contraseña);
    }

    @And("^presiono el botón \"([^\"]*)\"$")
    public void presionarBoton(String boton) {
        WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'" + boton + "')]"));
        signUpButton.click();
    }

    @Then("^verifico que el usuario ha sido creado exitosamente$")
    public void verificarCreacionUsuarioExitosa() {
        WebElement successMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assertions.assertTrue(successMessage.isDisplayed());
        Assertions.assertEquals("Usuario creado exitosamente", successMessage.getText());
    }
*/
    @AfterEach
    public void cerrarNavegador() {
        driver.quit();
    }
}
