package ExamplesAutomations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2AutomationLongIn {

	public static void main(String[] args) throws Exception {
		
		// Positive
		// go to https://canvas.instructure.com/login/canvas
		// enter valid user name "the name"
		// enter valid password "the pass"
		// click on the login button
		// you should see the dashboard
		
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://canvas.instructure.com/login/canvas");
		
		WebElement userNameTxt = driver.findElement(By.id("pseudonym_session_unique_id"));
		WebElement passwordTxt = driver.findElement(By.xpath("//input[@role='textbox']"));
		WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log')]"));
		WebElement logoOnTheLoginPage = driver.findElement(By.cssSelector("div.ic-Login-header__logo>img"));
		
		String validUser = "sabour.azadani@gmail.co";
		String invalidPassword = "Sahel786!";
		
	
		userNameTxt.sendKeys(validUser);
		passwordTxt.sendKeys(invalidPassword);
		loginBtn.click();
		
		WebElement errorMessage = driver.findElement(By.cssSelector("div.ic-flash__icon"));
		
		System.out.println(errorMessage.isDisplayed());
		System.out.println(errorMessage.getText());
		System.out.println("Error Message was shown" );
	}
}