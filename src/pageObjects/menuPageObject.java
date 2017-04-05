package pageObjects;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class menuPageObject extends pageObject{
	
	private String string;
	private Actions actions;
	private WebElement webElement;
	private WebElement web2;
	
	//Locators
	private By menuCategoriesLocator = By.xpath("//*[@id='block_top_menu']/ul/li");
	private By menuCategoriesNameLocator = By.xpath("//*[@id='block_top_menu']/ul");
	private By menuCategoryWomen = By.xpath("//*[@id='block_top_menu']/ul/li[1]/a");
	private By elemanetToWait = By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul");
	
	//Patterns and expected values
	private int expectedAmountOfCategories = 3;
	private String[] expectedCategories = {"WOMEN", "DRESSES", "T-SHIRTS"};

	public menuPageObject(WebDriver driver, WebDriverWait wait){
		super(driver, wait);
	}

	public int checkAmountOfElemnts(By by) {
		return isElementPresent(by);
		
	}
	
	public String[] checkCategoriesNames(By by) {
		string = getElementText(by);
		String[] result = string.split("\\n");
		return result;
	}
	
	public void checkIfBackgroundColorWasChangedOnHover(By by){
		
		//tu trzeba dokoñczyæ. zrobic funkcje hoverElement. zmienic void na jakas boolean
		actions = new Actions(driver);
		webElement = driver.findElement(by);
		web2 = driver.findElement(elemanetToWait);
		actions.moveToElement(webElement).build().perform();
		waitForElement(elemanetToWait);
		System.out.println(web2.getAttribute("style"));
	}

	public By getMenuCategoriesLocator() {
		return menuCategoriesLocator;
	}

	public int getExpectedAmountOfCategories() {
		return expectedAmountOfCategories;
	}

	public By getMenuCategoriesNameLocator() {
		return menuCategoriesNameLocator;
	}

	public String[] getExpectedCategories() {
		return expectedCategories;
	}

	public By getMenuCategoryWomen() {
		return menuCategoryWomen;
	}

}
