package week1day1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_25_Create_New_Opportunity {

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
		//			5. Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		Thread.sleep(2000);
		//			6. Enter Opportunity name as 'Salesforce Automation by Your Name,Get the text and Store it
		driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).sendKeys("Salesforce Automation by Sarath");
		String txt = driver.findElement(By.xpath("(//input[@class='slds-input'])[4]")).getText();
		System.out.println(txt);	

		// 			7. Choose close date as Today
		driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("6/3/2022"); 

		//			8. Select 'Stage' as Need Analysis
		Thread.sleep(5000);
		//	driver.findElement(By.xpath("(//label[text()='Stage']/following::span)[1]")).click();
		//	Thread.sleep(2000);
		//	driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		driver.findElement(By.xpath("(//label[text()='Stage']/following::div/button)[1]")).click();
		driver.findElement(By.xpath("(//label[text()='Stage']/following::div/button)[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/lightning-base-combobox-item/span/span[@title='Needs Analysis']")).click();

		//			9. click Save and VerifyOppurtunity Name
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(1000);
		String txt1 = driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(txt1);
		System.out.println(txt);
		String txt3 = "Opportunity " + txt + " was created.";


//        if(txt3 == txt1) {
//        	System.out.println("Opportunity created Sucessfully");
//        }
//        	else {
//            	System.out.println("Oppurtunity not created Sucessfully");
//	
//        	}
        }


	}


