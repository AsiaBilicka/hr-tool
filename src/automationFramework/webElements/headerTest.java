package automationFramework.webElements;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.headerPageObject;

public class headerTest {
	
	static headerPageObject objHeader;
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	private static String baseURL;
	private Boolean imagePresent;
	private Boolean phoneFormat;
	private Boolean contactButton;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, 10);
		
		objHeader = new headerPageObject(driver, wait);
		baseURL = "http://automationpractice.com";
		driver.navigate().to(baseURL);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	
	@Test
	public void header_shouldContainVisibleBannerPicture() {
		imagePresent = objHeader.checkIfImagePresent();
		Assert.assertTrue(imagePresent);
	}
	
	@Test
	public void header_shouldContainPhoneNumber() {
		phoneFormat = objHeader.checkIfPhoneNumberHasCorrectFormat();
		Assert.assertTrue(phoneFormat);
	}
	
	@Test
	public void header_shouldContainContactUsButton() {
		contactButton = objHeader.checkIfContactUsTextPresent();
		Assert.assertTrue(contactButton);
	}
	
	public void header_shouldContainSignInButton() {
		contactButton = objHeader.checkIfSignInTextPresent();
		Assert.assertTrue(contactButton);
	}

}
