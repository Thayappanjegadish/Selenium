package drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class baseclass {
	
	
	public static  WebDriver driver = null;
	public  String baseurl = null;
    public static FirefoxDriver FFdriver = null;
    

	public WebDriver open(String url) {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); 
			driver.manage().window().maximize();
			driver.get(url);
			System.out.println("The browser has been launched successfully");
			//			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		}catch(WebDriverException we) {
			System.out.println("[FAILED] unable to launch the browser");
		}
		return driver;
	}
	
	public void openinfirefox(String url) {
		try {
			WebDriverManager.firefoxdriver().setup();
			FFdriver = new FirefoxDriver();
	        FFdriver.manage().window().maximize();
	        FFdriver.get(url);
	        System.out.println("Firfox browser has been launched successfully");
		}catch(WebDriverException we) {
			
		}
	}


	public void close() {
		try {
			driver.close();
			System.out.println("The browser has been close successfiully");
		}catch(WebDriverException we) {
			System.out.println("Unable to close the browser");
		}
	}

	public void quit() {
		try {
			driver.quit();
			System.out.println("the browser has been closed successfully");
		}catch(WebDriverException we) {
			System.out.println("unable to close the browser");
		}
	}

//	public static void implicitwait() {
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	}

	public void timeoutalert() {
		try {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		}catch(WebDriverException we) {
		}
	}


	//SSL certification handling in browsers
	public void sslcertification() {
		try {
			DesiredCapabilities ch = DesiredCapabilities.chrome (); 
			ch.acceptInsecureCerts();
			ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
			ch.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);

		}catch(WebDriverException we) {

		}
	}




	public void click(String locator) {
		String[] split = locator.split("=", 2);
		String key = split[0].toUpperCase();
		String value = split[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				driver.findElement(By.id(value)).click();
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}
		}else if(key.equalsIgnoreCase("NAME")) {
			try {
				driver.findElement(By.name(value)).click();
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}
		}else if(key.equalsIgnoreCase("CLASS NAME")) {
			try {
				driver.findElement(By.className(value)).click();
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}
		}else if(key.equalsIgnoreCase("XPATH")) {
			try {
				driver.findElement(By.xpath(value)).click();
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}		
		}else if(key.equalsIgnoreCase("LINK TEXT")) {
			try {
				driver.findElement(By.linkText(value)).click();
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}	
		}else if(key.equalsIgnoreCase("PARTIAL LINK TEXT")) {
			try {
				driver.findElement(By.partialLinkText(value)).click();
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}	
		}else if(key.equalsIgnoreCase("TAGNAME")) {
			try {
				driver.findElement(By.tagName(value)).click();
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}	
		}else if(key.equalsIgnoreCase("CSS SELECTOR")) {
			try {
				driver.findElement(By.cssSelector(value)).click();
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}	
		}else {
			System.out.println("please provide the correct locator");
		}
	}

	public void type(String locator, String data) {
		String[] split = locator.split("=", 2);
		String key = split[0].toUpperCase();
		String value = split[1];
		if (key.equalsIgnoreCase("ID")) {
			try {
				driver.findElement(By.id(value)).sendKeys(data);
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}
		}else if(key.equalsIgnoreCase("NAME")) {
			try {
				driver.findElement(By.name(value)).sendKeys(data);
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}
		}else if(key.equalsIgnoreCase("CLASS NAME")) {
			try {
				driver.findElement(By.className(value)).sendKeys(data);
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}
		}else if(key.equalsIgnoreCase("XPATH")) {
			try {
				driver.findElement(By.xpath(value)).sendKeys(data);
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}		
		}else if(key.equalsIgnoreCase("LINK TEXT")) {
			try {
				driver.findElement(By.linkText(value)).sendKeys(data);
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}	
		}else if(key.equalsIgnoreCase("PARTIAL LINK TEXT")) {
			try {
				driver.findElement(By.partialLinkText(value)).sendKeys(data);
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}	
		}else if(key.equalsIgnoreCase("TAGNAME")) {
			try {
				driver.findElement(By.tagName(value)).sendKeys(data);
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}	
		}else if(key.equalsIgnoreCase("CSS SELECTOR")) {
			try {
				driver.findElement(By.cssSelector(value)).sendKeys(data);
			}catch(TimeoutException te) {
				System.out.println("the given webelement " + locator + "wasnt visible in DOM");
			}	
		}else {
			System.out.println("please provide the correct locator");
		}
	}


	public void framehandling() {
		driver.findElement(By.id("draggable")).click();
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));	
		a.dragAndDrop(source, target).build().perform();
	}
	
	
	

}
