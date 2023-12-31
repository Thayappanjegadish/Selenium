package usecases;

import Components.objectrepo;
import java.util.TimerTask;

import javax.management.timer.Timer;

//import java.util.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import drivers.baseclass;

public class canvas extends objectrepo {
	
	
	@Test
	public void usecasesteps()  {
		open("http://www.htmlcanvasstudio.com/");
		new objectrepo()
		.stepone();
		
	}
	
	
	
	

}
