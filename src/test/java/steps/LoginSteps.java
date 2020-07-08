package steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.HomePage;
import pages.LoginPage;

public class LoginSteps {
	private static WebDriver driver;
	protected HomePage homePage;
	
	@Before
	public static void initWebDriver() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\webdrivers\\chromedriver\\83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // Espera implícita
	}
	
	@After(order = 0)
	public static void quit() {
		driver.quit();
	}
	
	@After(order = 1)
	public void takeScreenshot(Scenario scenario) {
		TakesScreenshot camera = (TakesScreenshot) driver;
		File screenshot = camera.getScreenshotAs(OutputType.FILE);
		String scenarioId = scenario.getId().substring(scenario.getId().lastIndexOf(".feature:") + 9);
		try {
			String fileName = scenario.getName() + "_" + scenarioId + "_" + scenario.getStatus();
			Files.move(screenshot, new File("results/screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Dado("que o uauário está na página inicial")
	public void que_o_uauário_está_na_página_inicial() {
		homePage = new HomePage(driver);
		homePage.openPage();
	}

	@Quando("inserir os dados de usuário e senha válidos")
	public void inserir_os_dados_de_usuário_e_senha_válidos() {
		LoginPage loginPage = homePage.clickBtnSignIn();
		loginPage.toSign("marcelo@teste.com", "marcelo");
	}

	@Então("o usuário deverá estar logado")
	public void o_usuário_deverá_estar_logado() {
		assertTrue(homePage.isLogged("Marcelo Bittencourt"));
	}
	
}
