package automationFramework.webElements;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.headerPageObject;
import pageObjects.menuPageObject;

public class menuTest {
	
	static menuPageObject objMenu;
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	private static String baseURL;
	private Boolean isValid;
	private int amount;
	private String[] categories;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, 10);
		
		objMenu = new menuPageObject(driver, wait);
		baseURL = "http://automationpractice.com";
		driver.navigate().to(baseURL);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	@Test
	public void menu_shouldContainThreeCategories() {
		amount = objMenu.checkAmountOfElemnts(objMenu.getMenuCategoriesLocator());
		Assert.assertEquals(objMenu.getExpectedAmountOfCategories(), amount);
	}

	@Test
	public void menuCategories_shouldHaveProperTitles() {
		categories = objMenu.checkCategoriesNames(objMenu.getMenuCategoriesNameLocator());
		Assert.assertArrayEquals(objMenu.getExpectedCategories(), categories);
	}
	
	@Test
	public void menuCategoryWomen_whenHoverActionGiven_shouldChangeBackgroundColor() {
		objMenu.checkIfBackgroundColorWasChangedOnHover(objMenu.getMenuCategoryWomen());
	}
}
