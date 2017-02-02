package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPageObject {
	
	WebDriver driver;
	WebDriverWait wait;
	
	By logoImageLocator = By.id("LogoImage");
	By loginButtonLocator = By.id("LoginButton");
	By modalBoxLocator = By.id("LoginModal");
	By userNameLocator = By.id("Login1_UserName");
	By passwordLocator = By.id("Login1_Password");
	By logInButtononModalBoxLocator = By.id("Login1_Button1");
	
	public loginPageObject(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	
	public int takeLogoHeight(){
		return driver.findElement(logoImageLocator).getSize().getHeight();
	}
	
	public int takeLoginButtonHeight(){
		return driver.findElement(loginButtonLocator).getSize().getHeight();
	}
	
	public String takeLoginButtonText(){
		return driver.findElement(loginButtonLocator).getText();
	}
	
}
