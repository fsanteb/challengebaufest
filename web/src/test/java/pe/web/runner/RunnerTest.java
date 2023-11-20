package pe.web.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/users.feature", // Ruta a tus archivos .feature
    //tags= "@test",
    glue = "pe.web.steps", // Paquete donde están tus step definitions
    plugin = {"pretty", "html:target/cucumber-reports"} // Opciones de reportes
		)

public class RunnerTest {

}
