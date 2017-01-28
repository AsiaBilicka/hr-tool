import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
	static WebDriver driver;
	static ChromeOptions options;
	// public static void main(String[] args){
	// System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	//
	// options = new ChromeOptions();
	// options.addArguments("--start-maximized");
	// driver = new ChromeDriver(options);
	//
	// driver.get("https://multisportdiet.pl/");
	//
	// driver.findElement(By.className("btn-login")).click();
	// driver.findElement(By.id("login")).sendKeys("kelt");
	// driver.findElement(By.id("password")).sendKeys("123qwe");
	// driver.findElement(By.id("save")).submit();
	//
	// WebElement userDataElement =
	// driver.findElement(By.className("user-data"));
	// String userData = userDataElement.getText();
	// String user = userData.split(" ")[0];
	//
	// Assert.assertEquals("kelt", user);
	//
	//
	// driver.close();
	// }



	@Test
	public void test1() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);

		driver.get("https://multisportdiet.pl/");

		driver.findElement(By.className("btn-login")).click();
		driver.findElement(By.id("login")).sendKeys("kelt");
		driver.findElement(By.id("password")).sendKeys("123qwe");
		driver.findElement(By.id("save")).submit();

		WebElement userDataElement = driver.findElement(By.className("user-data"));
		String userData = userDataElement.getText();
		String user = userData.split(" ")[0];

		Assert.assertEquals("kelt", user);


		driver.close();



	}
}
