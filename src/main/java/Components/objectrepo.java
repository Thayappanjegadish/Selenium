package Components;

import java.util.ArrayList;
import java.util.TimerTask;

import javax.management.timer.Timer;

//import java.util.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import drivers.baseclass;

public class objectrepo extends baseclass {


	JavascriptExecutor js = (JavascriptExecutor)driver;


	public objectrepo() {

	}
	
	
	
	
	public objectrepo stepone() {
		driver.findElement(By.xpath("//input[@title='Draw a line']")).click();
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//canvas[@id='imageTemp']"));
		action.moveToElement(element, 20, 30).build().perform();
		driver.findElement(By.xpath("//input[@title='Draw a line']")).click();
		action.moveToElement(element, 10, 40).build().perform();
		WebElement From= driver.findElement(By.xpath("//input[@title='Draw a rectangle']"));
		action.dragAndDrop(From, element);
		driver.findElement(By.xpath("//input[@title='Draw a rectangle']")).click();
		action.moveToElement(element);
		driver.findElement(By.xpath("//input[@title='Use eraser']")).click();
//		Assert.assertEquals(actual, expected);
		SoftAssert obj = new SoftAssert();

		return this;
	}
	
	public objectrepo steptwo() {
		
		return this;
	}
	
	
	
	
	
	
	
	
	



}
