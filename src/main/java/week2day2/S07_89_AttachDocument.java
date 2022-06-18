package week2day2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class S07_89_AttachDocument {

	public static void main(String[] args) throws InterruptedException, AWTException {
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
		driver.findElement(By.xpath("//a/span[text()='Campaigns']/ancestor::one-app-nav-bar-item-root")).click();
//        driver.findElement(By.xpath("(//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'])[7]")).click();
        
        //			5. Click Bootcamp link
        
        driver.findElement(By.xpath("//a[@title='Bootcamp']")).click();
        
        // 			6. Click on Upload button 
        Thread.sleep(8000);
        //		Main upload Button
       // driver.findElement(By.xpath("(//slot//input[@name='fileInput']/following::label/span)[1]")).click();
        // Side upload button
        
        	driver.findElement(By.xpath("//a/div[@title='Upload Files']/ancestor::ul")).click();
        //			7. Select a file from local and upload  a pdf file
        
      Robot r= new Robot();
       Thread.sleep(3000);
       
      StringSelection str =new StringSelection("C:\\Users\\Ravi\\Downloads\\USB-Tethering");
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
      
      r.keyPress(KeyEvent.VK_CONTROL);
      r.keyPress(KeyEvent.VK_V);
      
      r.keyRelease(KeyEvent.VK_CONTROL);
      r.keyRelease(KeyEvent.VK_V);
      
      r.keyPress(KeyEvent.VK_ENTER);
      r.keyRelease(KeyEvent.VK_ENTER);
      
      Thread.sleep(3000);
      driver.findElement(By.xpath("//span[text()='Done']")).click(); 
              
        // 	8. Verify the file name displayed as link
      
   String txt= driver.findElement(By.xpath("//span[@class='itemTitle slds-text-body--regulardesktop uiOutputText']")).getText();
	System.out.println("File Name Attached :"+txt);
	}

}
