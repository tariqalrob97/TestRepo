package ChromeBrowser;
import java.util.HashMap;
import java.io.FileReader;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class LaunchApplication {
	
    
	@Test
	public void facebookTest()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Zahera\\git\\TestRepo\\TestNG\\Driver\\chromedriver.exe");
		final DesiredCapabilities dc = DesiredCapabilities.chrome();
		Properties properties = new Properties();
	       try(FileReader reader =  new FileReader("config")) {
	           
	           properties.load(reader);
	          
	          }catch (Exception e) {;
	          e.printStackTrace();
	          }
	     
		
		dc.setCapability(ChromeOptions.CAPABILITY, new ChromeOptions() {
		{
		    setExperimentalOption("mobileEmulation", new HashMap<String, Object>() {
		            {
		                put("deviceName", properties.getProperty("deviceName"));
		            }
		        });
		    }
		});
		
		
		WebDriver driver = new ChromeDriver(dc);
		driver.get(properties.getProperty("siteURL"));
	
		System.out.println(driver.getTitle());
	}
	

}
