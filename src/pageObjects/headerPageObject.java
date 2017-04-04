package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class headerPageObject extends pageObject{
	
	private WebElement webElemnt;
	private String string;
	private Boolean isValid;
	
	//Locators
	private By imageFileLocator = By.xpath("//*[@id='header']/div[1]/div/div/a/img");
	private By phoneLocator = By.xpath("//*[@id='header']/div[2]/div/div/nav/span/strong");
	private By contactUsLocator = By.xpath("//*[@id='contact-link']/a");
	private By signInLocator = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	
	//Patterns
	private String phoneNumberPattern = "\\d{4}-\\d{3}-\\d{3}";
	private String contactUsTextPattern = "Contact us";
	private String signInTextPattern = "Sign in";
	
	public headerPageObject(WebDriver driver, WebDriverWait wait){
		super(driver, wait);
	}
	
	public Boolean checkIfImagePresent() {
		webElemnt = driver.findElement(imageFileLocator);
		isValid = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", webElemnt);
		return isValid;
	}

	public Boolean checkIfPhoneNumberHasCorrectFormat() {
		string = getElementText(phoneLocator);
		isValid = string.matches(phoneNumberPattern);
		return isValid;
	}
	
	public Boolean checkIfContactUsTextPresent() {
		string = getElementText(contactUsLocator);
		isValid = string.matches(contactUsTextPattern);
		return isValid;
	}

	public Boolean checkIfSignInTextPresent() {
		string = getElementText(signInLocator);
		isValid = string.matches(signInTextPattern);
		return isValid;
	}
}
