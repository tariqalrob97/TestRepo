package ChromeBrowser;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Selectors.homeSelectors;
import Utils.LibraryUtils;
import template.initializingBrowser;

public class Setup {
	

	public static void clickOnLocation(WebDriver driver)
	{
		try {
			Thread.sleep(50000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		LibraryUtils.waitForElementToBeClickable(driver, driver.findElement(By.cssSelector(homeSelectors.locationButton)), 25).click();//click to add to cart button
	}
	
}
