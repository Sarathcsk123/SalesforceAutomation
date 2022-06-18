package week1day1;

import java.time.Duration;

import javax.xml.xpath.XPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_26_Edit_Opportunity {

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


		// 6. Click on the Dropdown icon and Select Edit

		Thread.sleep(4000);

		driver.findElement(By.xpath("(//span[@class='slds-icon_container slds-icon-utility-down'])[1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

     //  7.  Choose close date as Tomorrow date     
		
		driver.findElement(By.xpath("//input[@name='CloseDate']")).clear();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("6/7/2022");
		
		Thread.sleep(4000);

		
      // 8.  Select 'Stage' as Perception Analysis
		driver.findElement(By.xpath("(//label[text()='Stage']/following::div/button)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/lightning-base-combobox-item/span/span[@title='Perception Analysis']")).click();
		
		String txt1 = driver.findElement(By.xpath("(//label[text()='Stage']/following::div/button)[1]")).getText();
		
		System.out.println(txt1);
		

	   // 9.  Select Deliver Status as In Progress
			Thread.sleep(4000);
			WebElement	Element =	driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[9]"));
			  driver.executeScript("arguments[0].scrollIntoView();", Element);
		
			driver.findElement(By.xpath("(//div[@class='slds-form-element__control'])[9]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("( //div/lightning-base-combobox-item)[13]//span[@title='In progress']")).click();
			
		// 10. Enter Description as SalesForce	

		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");
		
		// 11. Click on Save and Verify Stage as Perception Analysis
		
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
  System.out.println("Stage :" +txt1+ " Edited sucessfully");
		

		

		
		
} 
}
