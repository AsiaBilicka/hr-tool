package automationFramework.e2e;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.modalBoxPageObject;

public class loginTest {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	static modalBoxPageObject objModalBox;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		objModalBox = new modalBoxPageObject(driver, wait);
		
		driver.get("http://hrtooltest.digitaltesting.be/");
		objModalBox.clickLogin1();
		objModalBox.waitForElement(objModalBox.getModalBoxLocator());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		objModalBox = new modalBoxPageObject(driver, wait);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void user_canLogInWithValidCredentials() {
		objModalBox.typeUserName("Aska");
		objModalBox.typePassword("passwrd");
		objModalBox.submit();
	}

}
