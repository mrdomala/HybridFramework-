package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusablecomponents.ReadPropertyFile;
import uistore.GiftsPageDetails;

public class Gifts extends ReadPropertyFile{
	public static Logger log=Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {
		
		driver=DriverInitialisation();
	}
	@Test
	public void GiftHover() throws InterruptedException {
		
		
		
		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");	
		
		
		GiftsPageDetails g=new GiftsPageDetails(driver);
		Actions action = new Actions(driver);

		action.moveToElement(g.getGifts()).perform();
		g.getgiftforkids().click();
		
	}
	@AfterTest
	public void close() {
		
		driver.quit();
		
	}
		
		

	}
