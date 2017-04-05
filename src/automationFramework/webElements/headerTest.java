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
	private Boolean isValid;

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

	//PICS
	@Test
	public void header_shouldContainVisibleBannerPicture() {
		isValid = objHeader.checkIfImagePresent(objHeader.getBannerFileLocator());
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void header_shouldContainLogoPicture() {
		isValid = objHeader.checkIfImagePresent(objHeader.getLogoFileLocator());
		Assert.assertTrue(isValid);
	}
	
	//Texts
	@Test
	public void header_shouldContainPhoneNumber() {
		isValid = objHeader.checkIfTextPresent(objHeader.getPhoneLocator(), objHeader.getPhoneNumberPattern());
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void header_shouldContainContactUsButton() {
		isValid = objHeader.checkIfTextPresent(objHeader.getContactUsLocator(), objHeader.getContactUsTextPattern());
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void header_shouldContainSignInButton() {
		isValid = objHeader.checkIfTextPresent(objHeader.getSignInLocator(), objHeader.getSignInTextPattern());
		Assert.assertTrue(isValid);
	}
	
	//Elements
	@Test
	public void header_shouldContainSearchForm() {
		isValid = objHeader.checkIfElementIsPresent(objHeader.getSearchFormLocator());
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void header_shouldContainSearchButton() {
		isValid = objHeader.checkIfElementIsPresent(objHeader.getSearchButtonLocator());
		Assert.assertTrue(isValid);
	}
	
	@Test
	public void header_shouldContainCart() {
		isValid = objHeader.checkIfElementIsPresent(objHeader.getCartLocator());
		Assert.assertTrue(isValid);
	}
	
}
