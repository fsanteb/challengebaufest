package pe.web.selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

@TestMethodOrder(OrderAnnotation.class)
public class ChromeDriverTest {
	WebDriver driver;
	
	@BeforeAll
	static void configuracionInicial() {
		//1. Configurar y descargar el driver (chromedriver)
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeEach
	void instanciarDriver() {
		//2. instancia
		driver = new ChromeDriver();
	}
	
	@AfterEach
	void cerrarDriver() {
		//Cerramos la web
		driver.quit();
	}
	
	@Order(1)
	@Test
	void abrirPaginaSeleniumTest() {		
		//3. abrir el navegador y cargar la pagina selenium.dev
		driver.get("https://demoblaze.com/index.html");
		
		System.out.println("Título de la página: " + driver.getTitle());
		System.out.println("url: " + driver.getCurrentUrl());
		
		Assertions.assertEquals("STORE", driver.getTitle());		
		
	}
}
