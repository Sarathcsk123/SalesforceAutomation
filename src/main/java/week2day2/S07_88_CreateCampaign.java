package week2day2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_88_CreateCampaign {

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
		driver.findElement(By.xpath("//p[@class='slds-truncate'][text()='Sales']")).click();
		
		//			4. Click on Campaigns tab 
		
		Thread.sleep(4000);
		
        driver.findElement(By.xpath("(//a/span[text()='Campaigns']/following::one-app-nav-bar-item-dropdown)[1]")).click();
        Thread.sleep(3000);
		
		//			5. Click on New button
		driver.findElement(By.xpath("//one-app-nav-bar-menu-item[@class='slds-dropdown__item'][1]")).click();
		
		
		// 			6. Enter Campaign name as 'Bootcamp',Get the text and Store it 
		
		driver.findElement(By.xpath("(//label/span[text()='Campaign Name']/following::input)[1]")).sendKeys("Bootcamp");
		String txt =driver.findElement(By.xpath("(//label/span[text()='Campaign Name']/following::input)[1]")).getText();
		System.out.println(txt);
		// 			7. Choose Start date as Tomorrow
		Thread.sleep(4000);
		WebElement	Element =	driver.findElement(By.xpath("(//div/div/div/label/span[text()='Start Date']/following::div)[1]"));
		  driver.executeScript("arguments[0].scrollIntoView();", Element);
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		  
//		  DateFormat dtformat = new SimpleDateFormat("MM/dd/yyyy");
//		  Date dt =new Date();
//		  String Date1 = dtformat.format(dt);
//		  Thread.sleep(2000); 
		  
		  LocalDate today = LocalDate.now();
		  LocalDate tomorrow = today.plusDays(1);
		  String tomm =tomorrow.format(DateTimeFormatter.ISO_DATE);
		  driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys(tomm);
		//  driver.findElement(By.xpath("(//div/div/div/label/span[text()='Start Date']/following::div)[1]")).click();
		//  driver.findElement(By.xpath("(//div/div/div/label/span[text()='Start Date']/following::div)[1]")).sendKeys("6/17/2022");
		
		//			8.End date as Tomorrow+1
		  
		  
	LocalDate today1 =LocalDate.now();
	LocalDate tomorrow1 =today.plusDays(2);
	String tomm1=tomorrow1.format(DateTimeFormatter.ISO_DATE);
	driver.findElement(By.xpath("(//input[@class=' input'])[3]")).sendKeys(tomm1);
	
	 // 9. click Save and Verify the newly created Campaign
	//=>//div//span[text()='success']
	// -> //div[@data-aura-class='forceToastMessage']/lightning-icon/span
    driver.findElement(By.xpath("//button/span[text()='Save']")).click();
  
	String txt1= driver.findElement(By.xpath("//div[@data-key='success']/div//span")).getText();
	System.out.println(txt1);
	}

}
