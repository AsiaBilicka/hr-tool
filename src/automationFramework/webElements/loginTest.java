package automationFramework.webElements;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import pageObjects.loginPageObject;

public class loginTest {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	static loginPageObject objLogin;
	
	@BeforeClass
	public static void setUpBeforeClass(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.get("http://hrtooltest.digitaltesting.be/");
	}
	
	@AfterClass
	public static void tearDownAfterClass(){
		driver.quit();
	}
	
	@Before
	public void setUp(){
		objLogin = new loginPageObject(driver, wait);
	}
	
	@Test
	public void loginPage_shouldContainLogo(){
		int logoHeight = objLogin.takeLogoHeight();
		assertTrue(logoHeight > 0);
	}
	
	@Test
	public void loginButton_shouldContanLoginText(){
		String loginButtonText = objLogin.takeLoginButtonText();
		assertTrue(loginButtonText.contains("Login"));
	}
	
	@Test
	public void loginPage_shouldContanLoginButton(){
		int loginButtonHeight = objLogin.takeLoginButtonHeight();
		assertTrue(loginButtonHeight > 0);
	}

//	@Test
//	public void login(){
//		
//		WebElement loginButton = driver.findElement(By.id("LoginButton"));
//		loginButton.click();
//	
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Login1_Button1")));
//		WebElement userName = driver.findElement(By.id("Login1_UserName"));
//		WebElement password = driver.findElement(By.id("Login1_Password"));
//		userName.sendKeys("name");
//		password.sendKeys("password");
//		WebElement loginButton1 = driver.findElement(By.id("Login1_Button1"));
//		loginButton1.click();
//	}
}


