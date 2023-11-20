package pe.web.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginLogoutTest {
	WebDriver driver;

	@BeforeAll
	static void configuracionInicial() {
		// 1. Configurar y descargar el driver (chromedriver)
		WebDriverManager.chromedriver().setup();
	}

	@BeforeEach
	void instanciarDriver() {
		// 2. instancia
		driver = new ChromeDriver();
	}

	@AfterEach
	void cerrarDriver() {
		// Cerramos la web
		driver.quit();
	}

    @Test
    public void loginYLogout() {
        // Abrir la página web
        driver.get("https://www.demoblaze.com/index.html");

        // Realizar el login con el usuario dado de alta
        WebElement loginLink = driver.findElement(By.id("login2"));
        loginLink.click();

        WebElement usernameField = driver.findElement(By.id("loginusername"));
        usernameField.sendKeys("FSANTE1");

        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        // Aquí se agrega una espera para asegurarte de que el login se haya realizado correctamente
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        // Realizar el logout
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout2")));
        logoutLink.click();

        // Aquí puedes agregar una espera para asegurarte de que el logout se haya realizado correctamente
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
    }

}
