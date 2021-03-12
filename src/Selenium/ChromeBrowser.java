package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser {

	public static void main(String[] args) {
		// step 1. to open a chrome browser we to set up
		// system.SetProperty to open chromedriver file
		// Syntax for system.setProperty ( " webdriver.chrom.driver", <pathh to file>
		// for window users we will add ".exr" extension for mac users we do not add

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver");

		// step 2 we need to create a reference to webdriver interface
		// then creat obj of chromeDriver class
		WebDriver driver = new ChromeDriver();

		// step 3 we need to open http://tek-school.com/retail/
		// in order to open a website with selenium webdriver. we need to use
		// .get() method and pass url as a parameter
		// we need to define the pageload timeout so webdriver should not throw an
		// exception
		// for this issue.
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);

		// global wait or impicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// delet cookies with selenium
		// driver.manage(). deleteAllCookies();
		// .get will open website url

		driver.get("https://google.com/");

		// I want to print the page title or Website title
		String thisIsTheTitleImExpecting = "Welcome to TekSchool";
		String actualPageTitle = driver.getTitle();

		// we can maximize the page
		System.out.println("this is the current size of my broswer" + driver.manage().window().getSize()); // 800 X 600
		driver.manage().window().maximize();
		System.out.println("this is the maximum size of my broswer" + driver.manage().window().getSize());
		System.out.println("This is current page Title " + actualPageTitle);

		// I want to print the url of page which I am on it.
		String currentURL = driver.getCurrentUrl();

		// to close an opened browser with webdriver we can use two methods
		// .close(() -- this method will close the only tab opened in browser
		// .quite() -- this method will close all opened tab in a browser

		// driver.close();
	}
}
