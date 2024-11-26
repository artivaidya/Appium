package appiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Test1 {
	public AndroidDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeTest
	
	public void setup() throws MalformedURLException {
		
		String appiumServerUrl= "http://127.0.0.1:4725/wd/hub";
		DesiredCapabilities caps=new DesiredCapabilities();
		/*dc.setCapability( "platformName",  "Android");
		dc.setCapability( "automationName",  "UiAutomator2");
		//dc.setCapability( "app",  System.getProperty("user.dir")+"/Apps/ApiDemos.apk");
		//dc.setCapability("app", "/Users/Ancha/eclipse-workspace/Appium_project/src/test/resources/Apps/ApiDemos.apk");
		dc.setCapability("deviceName", "Android emulator");*/
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "emulator-5554"); // Use your emulator/device ID
		caps.setCapability("browserName", "Chrome");//browser name
		
		caps.setCapability("automationName", "UiAutomator2");
		
		driver=new AndroidDriver(new URL(appiumServerUrl),caps);
		
	}


	@Test
	public void test() {
		//WebDriverManager.chromedriver().setup();
		//ChromeDriver driver= new ChromeDriver();

		driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
		
	}
	@AfterTest
	public void close() {
		driver.close();
	}

}
