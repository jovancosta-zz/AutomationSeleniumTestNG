package br.com.testngselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebDriverTestNGDemo {

	@Test
	public void calculatepercent10() {
		//Variavel que contem o resultado esperado do teste		
		expectedResult = "0.2";
		
		// Limpa o campo antes de enviar as informacoes
		driver.findElement(By.id("cpar1")).clear();
		
		// Preenche o campo com as informacoes
		driver.findElement(By.id("cpar1")).sendKeys("2");

		// Limpa o campo antes de enviar as informacoes
		driver.findElement(By.id("cpar2")).clear();
		
		// Preencher o campo com as informacoes
		driver.findElement(By.id("cpar2")).sendKeys("10");

		// Clica no botao para calcular
		driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td/input[2]")).click();

		// Captura o resultado e salva numa string
		actualResult = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();

		//Verifica o resultado da operacao
		Assert.assertEquals(actualResult, expectedResult, "O teste falhou,");
	}

	@Test
	public void calculatepercent100() {
		
		//Variavel que contem o resultado esperado do teste		
		expectedResult = "20";
		
		// Limpa o campo antes de enviar as informacoes
		driver.findElement(By.id("cpar1")).clear();
		
		// Preenche o campo com as informacoes
		driver.findElement(By.id("cpar1")).sendKeys("20");

		// Limpa o campo antes de enviar as informacoes
		driver.findElement(By.id("cpar2")).clear();
		
		// Preenche o campo com as informacoes
		driver.findElement(By.id("cpar2")).sendKeys("100");

		// Clica no botao para calcular
		driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td/input[2]")).click();

		// Captura o resultado e salva numa string
		actualResult = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();

		//Verifica o resultado da operacao
		Assert.assertEquals(actualResult, expectedResult, "O teste falhou,");
	}

	@Test
	public void calculatepercent1000() {
		
		//Variavel que contem o resultado esperado do teste	(errado)	
		expectedResult = "20";
		
		// Limpa o campo antes de enviar as informacoes
		driver.findElement(By.id("cpar1")).clear();
		
		// Preenche o campo com as informacoes
		driver.findElement(By.id("cpar1")).sendKeys("20");

		// Limpa o campo antes de enviar as informacoes
		driver.findElement(By.id("cpar2")).clear();
		
		// Preenche o campo com as informacoes
		driver.findElement(By.id("cpar2")).sendKeys("1000");

		// Clica no botao para calcular
		driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td/input[2]")).click();

		// Captura o resultado e salva numa string
		actualResult = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();

		//Verifica o resultado da operacao
		Assert.assertEquals(actualResult, expectedResult, "O teste falhou,");
	}
	
	@Test
	public void Intentional_Skip() {

		if (true) {
			// Gera um throw exception para pular o teste
			throw new SkipException("Test Intentional_Skip foi ignorado");
		}
	}
	
	@BeforeTest
	public void setUp() {
		
		//Cria uma instancia do driver do firefox e abre o browser (testado na versão 44)	
		driver = new ChromeDriver();
		
		// Implicit wait, aguarda 10 segundos antes de gerar excecao	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Navega ate do website
		driver.navigate().to("http://www.calculator.net");
		
		// Maximiza a janela do browser
		driver.manage().window().maximize();

		// Clica no link da calculadora matematica
		driver.findElement(By.linkText("Math Calculators")).click();

		// Clica no link da calculadora de percentual
		driver.findElement(By.linkText("Percentage Calculator")).click();
	}

	@AfterTest
	public void tearDown() {
		
		//Fecha a janela atual do Browser e mantem o processo aberto
		driver.close();
		
		// Fechas as janelas do Browser e finaliza o processo (driver)
		// driver.quit();
	}

	WebDriver driver;
	String expectedResult;
	String actualResult;
}