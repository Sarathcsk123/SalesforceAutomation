package week1day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_27_Delete_Oppurtunity {

	public static void main(String[] args) throws InterruptedException {
		
		// TODO Auto-generated method stub
		// Open Browser
		WebDriverManager.chromedriver().setup();
		// Disable Notification
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// Chrome Instance
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		//			1. Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("BootcampSel@123");
		driver.findElement(By.id("Login")).click();

		//			2. Click on toggle menu button from the left corner		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();

		//			3. Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//p[@class='slds-truncate'][text()='Sales']")).click();

		//			4. Click on Opportunity tab 
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//span[@class='slds-truncate'][text()='Opportunities']"));
		JavascriptExecutor executor =(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",element);
		Thread.sleep(4000);

		// 5.  Search the Opportunity 'Salesforce Automation by Your Name'

		driver.findElement(By.xpath("//input[@name=\"Opportunity-search-input\"]")).sendKeys("Salesforce Automation by Sarath");
		driver.findElement(By.xpath("//button[@name='refreshButton']")).click();


		// 6.  Click on  the Dropdown icon and Select Delete

		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[@class='slds-icon_container slds-icon-utility-down'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		
	String txt =driver.findElement(By.xpath("//div[@data-key='success']")).getText();
		System.out.println(txt);
	}

}
