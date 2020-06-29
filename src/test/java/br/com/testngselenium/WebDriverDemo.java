package br.com.testngselenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**Classe criada para demosntra o comportamento do webdriver sem o apoio de um framework de testes**/

public class WebDriverDemo {

	public static void main(String[] args) {
		//Cria uma instancia do firefox e abre o browser (Testado na versão 44 do navegador - Selenium 2.53)
		WebDriver driver = new ChromeDriver();

		// Implicit wait, aguarda 10 segundos antes de gerar excecao	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Navega até o site
		driver.navigate().to("http://www.calculator.net/");

		// Maximiza a janela do browser
		driver.manage().window().maximize();

		// Clica no link da calculadora matematica
		driver.findElement(By.linkText("Math Calculators")).click();

		// Clica no link da calculadora de percentual
		driver.findElement(By.linkText("Percentage Calculator")).click();

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
		String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();

		// Imprime na tela uma mensagem com o resultado
		System.out.println("O resultado é " + result);

		// Fecha o Browser
		driver.close();
	}
}