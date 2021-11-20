package pageobject;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import reusablecomponents.ReadPropertyFile;
import uistore.MouseActionsDetails;

public class MouseActions extends ReadPropertyFile {
	public static Logger log = Logger.getLogger(ReadPropertyFile.class.getName());

	@BeforeTest
	public void initialise() throws IOException {

		driver = DriverInitialisation();
	}

	@Test
	public void logintest() throws InterruptedException {
		MouseActionsDetails m = new MouseActionsDetails(driver);

		driver.get(p.getProperty("url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		log.info("navigation to url");
		m.getallofit().click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);

		action.moveToElement(m.getimagemovment()).perform();
		Thread.sleep(10000);

	}

	@AfterTest
	public void close() {

		driver.close();
		driver = null;

	}
}
