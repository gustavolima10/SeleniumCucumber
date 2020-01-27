package br.ce.gutavolima.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;





@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features/inserir_conta.feature",
		glue = "br.ce.gustavolima.steps",
		tags = {},
		plugin = {"pretty", "html: target/report-html", "json: target/report.jason"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false, //Somente valida se os cenarios estao ok, nao executa
		strict = false //Se possuir um passo sem definição ele aponta erro e nao o coloca como undefined
		)
public class RunnerTest {
	
	@BeforeClass
	public static void reset() {
		WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("https://srbarriga.herokuapp.com/login");
		driver.findElement(By.id("email")).sendKeys("gustavo.lima2@live.com");
		driver.findElement(By.id("senha")).sendKeys("Sparta26");
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.linkText("reset")).click();
		driver.quit();
	}

	
}
