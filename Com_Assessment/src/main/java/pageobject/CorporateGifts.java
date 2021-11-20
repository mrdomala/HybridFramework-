package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusablecomponents.ReadPropertyFile;
import uistore.CorporateGiftDetails;

public class CorporateGifts extends ReadPropertyFile {
	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void PersonalizedGift() throws InterruptedException {

		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");
		CorporateGiftDetails c = new CorporateGiftDetails(driver);
		c.getCorporate().click();
		c.getFullName().sendKeys("Rahul");
		c.getEmail().sendKeys("Rahuldomala@gmail.com");
		c.getPhone().sendKeys("9876512345");
		c.getDesc().sendKeys("Hey mayan!");
		c.getSubmit().click();
		log.info("Submitted successfully");

	}

	@AfterTest
	public void close() {

		driver.quit();

	}

}