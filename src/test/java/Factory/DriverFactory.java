package Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {


	static WebDriver driver=null;
	
	public static void browserLunch(String Browser) {

		WebDriverManager.chromedriver().setup();

		if(Browser.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();	
		}else if(Browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("ie")) {
			driver= new InternetExplorerDriver();
		}





	}
	public static WebDriver getDriver() {
		
		return driver;
	}

}
