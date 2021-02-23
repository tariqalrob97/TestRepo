package ChromeBrowser;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class LaunchApplication {
    

//	public static void main(String[] args) {
//		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zahera\\Downloads\\seleniumjar\\chromedriver.exe");
//		final DesiredCapabilities dc = DesiredCapabilities.chrome();
//		dc.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions() {
//		{
//		    setExperimentalOption("mobileEmulation", new HashMap<String, Object>() {
//		            {
//		                put("deviceName", "iPhone X");
//		            }
//		        });
//		    }
//		});
//		
//		WebDriver driver = new ChromeDriver(dc);
//		driver.get("https://www.facebook.com");
//	
//		System.out.println(driver.getTitle());
//
//	}
//	
	
	
	@Test
	public void facebookTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zahera\\Downloads\\seleniumjar\\chromedriver.exe");
		final DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions() {
		{
		    setExperimentalOption("mobileEmulation", new HashMap<String, Object>() {
		            {
		                put("deviceName", "iPhone X");
		            }
		        });
		    }
		});
		
		WebDriver driver = new ChromeDriver(dc);
		driver.get("https://www.ballarddesigns.com");
	
		System.out.println(driver.getTitle());
	}

}
