package br.com.testngselenium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/** Classe criada para demonstra o comportamento das anatoções do TestNG **/

public class TestNGAnnotationsDemo {

	@Test
	public void testCase1() {
		System.out.println("@Test - ***Caso de teste 1***");
	}

	@Test
	public void testCase2() {
		System.out.println("@Test - ***Caso de teste 2***");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("@BeforeMethod - Executado antes de um método");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("@AfterMethod - Executado depois de um método");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("@BeforeClass - Executado antes da classe");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("@AfterClass - Executado depois da classe");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("@BeforeTest - Executado antes dos testes");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("@AfterTest - Executado depois dos testes");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("@BeforeSuite - Executado antes da suíte de testes");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("@AfterSuite - Executado depois da suíte de testes");
	}
}
