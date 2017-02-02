package automationFramework.webElements;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.modalBoxPageObject;

public class modalBoxTest {

	public static WebDriver driver;
	public static WebDriverWait wait;

	static modalBoxPageObject objModalBox;

	@BeforeClass
	public static void setUpBeforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		objModalBox = new modalBoxPageObject(driver, wait);

		driver.get("http://hrtooltest.digitaltesting.be/");
		objModalBox.clickLogin1();
		objModalBox.waitForElement(objModalBox.getModalBoxLocator());
	}

	@AfterClass
	public static void tearDownAfterClass() {
		driver.quit();
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {

	}

	@Test
	public void modalBox_shouldBeShown() {
		int modalBoxHeight = objModalBox.takeModalBoxHeight();
		assertTrue(modalBoxHeight > 0);
	}

	@Test
	public void modalBox_shouldContainUserNameInput() {
		int userNameInputHeight = objModalBox.takeUserNameInputHeight();
		assertTrue(userNameInputHeight > 0);
	}

	@Test
	public void modalBox_shouldContainPasswordInput() {
		int passwordInputHeight = objModalBox.takePasswordInputHeight();
		assertTrue(passwordInputHeight > 0);
	}

	@Test
	public void modalBox_shoudlContainLogInButton() {
		int logInButtonOnModalBoxHeight = objModalBox.takeLogInButtonOnModalBoxHeight();
		assertTrue( logInButtonOnModalBoxHeight > 0);
	}

}
