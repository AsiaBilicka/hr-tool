package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pageObject {
	WebDriver driver;
	WebDriverWait wait;
	
	public pageObject(WebDriver driver, WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
	}
	
	public int isElementPresent(By by){
		return driver.findElements(by).size();
	}
//	
//	public boolean checkIfElementIsVisible(By by) {
//		return driver.findElement(by).isDisplayed();
//	}
//	
	public String getElementText(By by){
		return driver.findElement(by).getText();
	}

	public void waitForElement(By by){
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
