package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class modalBoxPageObject {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By loginButtonLocator = By.id("LoginButton");
	By modalBoxLocator = By.id("LoginModal");
	By userNameLocator = By.id("Login1_UserName");
	By passwordLocator = By.id("Login1_Password");
	By logInButtononModalBoxLocator = By.id("Login1_Button1");
	
	public modalBoxPageObject(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	
	public int takeModalBoxHeight(){		
		return driver.findElement(modalBoxLocator).getSize().getHeight();
	}
	
	public int takeUserNameInputHeight(){
		return driver.findElement(userNameLocator).getSize().getHeight();
	}

	public int takePasswordInputHeight(){
		return driver.findElement(passwordLocator).getSize().getHeight();
	}
	
	public int takeLogInButtonOnModalBoxHeight(){
		return driver.findElement(logInButtononModalBoxLocator).getSize().getHeight();
	}
	
	public void clickLogin1(){
		driver.findElement(loginButtonLocator).click();
	}
		
	public void waitForElement(By by){
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void typeUserName(String username){
		driver.findElement(userNameLocator).sendKeys(username);
	}
	
	public void typePassword(String password){
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void submit(){
		driver.findElement(logInButtononModalBoxLocator).click();
	}

	public By getModalBoxLocator() {
		return modalBoxLocator;
	}
	
	

}
