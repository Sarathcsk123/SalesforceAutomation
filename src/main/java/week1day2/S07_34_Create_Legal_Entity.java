package week1day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_34_Create_Legal_Entity {

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

		//			3.Click View All and click Legal Entities from App Launcher
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
		
		// 4. Click on the Dropdown icon in the legal Entities tab
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@role='button'][@class='slds-button slds-button_reset'])[27]")).click();
		
		// 5. Click on New Legal Entity
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//one-app-nav-bar-menu-item[@class='slds-dropdown__item'])[1]")).click();
		
		// 6. Enter Name as 'Salesforce Automation by Your Name'
		
		 driver.findElement(By.xpath("(//input[@class=' input'])")).sendKeys("Salesforce Automation by Sarath");
		 
	   // 7.Click save and verify Legal Entity Name
		 
		 driver.findElement(By.xpath("(//div[@class='actionsContainer']//button)[4]")).click();
		 
		 String txt =driver.findElement(By.xpath("//div[@data-key='success']/div//span")).getText();
		 
		 System.out.println(txt);
		}
	

}
