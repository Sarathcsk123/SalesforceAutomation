package week2day1;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class S07_67_CustomerServiceOptions {

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
				
				 //        2. Login with the credentials
				driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
				driver.findElement(By.xpath("//input[@id='password']")).sendKeys("BootcampSel@123");
				driver.findElement(By.id("Login")).click();
				
				//  3.  Click on Learn More link in Mobile Publisher
				
				driver.findElement(By.xpath("//span[text()='Learn More']")).click();
				
				// 4.  MouseHover on Products and Select Service 
//				Thread.sleep(3000);
//				  JavascriptExecutor jse=(JavascriptExecutor)driver;
//				        WebElement  txt= (WebElement)  jse.executeScript("return document.querySelector(\"#c360-hgf-nav\").shadowRoot.querySelector(\"header > div:nth-child(2) > div > div > div > div > div.globalnavbar-header-container > nav > ul > li.nav-item.menu_item_0 > button\")");
//				        String js ="arguments[0].setAttribute('class','nav-item-link child-menu')"; 
//				        ((JavascriptExecutor)driver).executeScript(js, txt);
				
		        //Get handles of the windows
		        String mainWindowHandle = driver.getWindowHandle();
		        Set<String> allWindowHandles = driver.getWindowHandles();
		        Iterator<String> iterator = allWindowHandles.iterator();
		        
		        
		        // Here we will check if child window has other child windows and will fetch the heading of the child window
		        while (iterator.hasNext()) {
		            String ChildWindow = iterator.next();
		                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {	
		                driver.switchTo().window(ChildWindow);
		                }
		        }
				
				Thread.sleep(3000);     
	
				   Shadow shadow =new Shadow(driver);
				   Thread.sleep(3000); 
			       WebElement	sd =  shadow.findElementByXPath("//span[text()='Products']");
				   sd.click();
				   Actions  act =new Actions(driver);
				   act.moveToElement(sd).build().perform();
				   
				   WebElement	sd1 =  shadow.findElementByXPath("//span[text()='Service']");
				   sd1.click();
				   
				   System.out.println("Below mentioned tabs are available");
				   
				   String	sd2 =  shadow.findElementByXPath("//span[text()='Products']").getText();
				   System.out.println(sd2);
				   String	sd3 =  shadow.findElementByXPath("//span[text()='Resources']").getText();
				   System.out.println(sd3);
				   String	sd4 =  shadow.findElementByXPath("//span[text()='Support']").getText();
				   System.out.println(sd4);
				   String	sd5 =  shadow.findElementByXPath("//span[text()='Company']").getText();
				   System.out.println(sd5);
				   String	sd6 =  shadow.findElementByXPath("//span[text()='Salesforce+']").getText();
				   System.out.println(sd6);
	}
	}



