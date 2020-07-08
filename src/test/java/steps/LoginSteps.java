package steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
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
	
	@After
	public static void quit() {
		driver.quit();
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
