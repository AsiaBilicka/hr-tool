package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class headerPageObject extends pageObject{
	
	private WebElement webElement;
	private String string;
	private Boolean isValid;
	
	//Locators
	private By bannerFileLocator = By.xpath("//*[@id='header']/div[1]/div/div/a/img");
	private By logoFileLocator = By.xpath("//*[@id='header_logo']/a/img");
	private By phoneLocator = By.xpath("//*[@id='header']/div[2]/div/div/nav/span/strong");
	private By contactUsLocator = By.xpath("//*[@id='contact-link']/a");
	private By signInLocator = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	private By searchFormLocator = By.id("search_query_top");
	private By searchButtonLocator = By.xpath("//*[@id='searchbox']/button");
	private By cartLocator = By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a");
	
	//Patterns and expected values
	private String phoneNumberPattern = "\\d{4}-\\d{3}-\\d{3}";
	private String contactUsTextPattern = "Contact us";
	private String signInTextPattern = "Sign in";
	
	public headerPageObject(WebDriver driver, WebDriverWait wait){
		super(driver, wait);
	}
	
	public Boolean checkIfImagePresent(By by) {
		webElement = driver.findElement(by);
		isValid = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", webElement);
		return isValid;
	}
	
	public Boolean checkIfTextPresent(By by, String expectedString) {
		string = getElementText(by);
		isValid = string.matches(expectedString);
		return isValid;
	}
	
	public Boolean checkIfElementIsPresent(By by) {
		return isElementPresent(by)>0;
	}

	
	
	
	
	
	
	
	public By getBannerFileLocator() {
		return bannerFileLocator;
	}

	public By getContactUsLocator() {
		return contactUsLocator;
	}


	public By getSignInLocator() {
		return signInLocator;
	}

	public By getPhoneLocator() {
		return phoneLocator;
	}
	
	public By getLogoFileLocator() {
		return logoFileLocator;
	}

	public String getPhoneNumberPattern() {
		return phoneNumberPattern;
	}

	public String getSignInTextPattern() {
		return signInTextPattern;
	}

	public String getContactUsTextPattern() {
		return contactUsTextPattern;
	}

	public By getSearchFormLocator() {
		return searchFormLocator;
	}

	public By getSearchButtonLocator() {
		return searchButtonLocator;
	}

	public By getCartLocator() {
		return cartLocator;
	}

}
