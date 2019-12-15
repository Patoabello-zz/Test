package Android.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class First {

	Parametric p = new Parametric();

	public WebDriver driver;

	@BeforeMethod

	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability(CapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability("platformVersion", "9");

		File file = new File("C:\\Documentos", "app-debug.apk");
		capabilities.setCapability("app", file.getAbsolutePath());

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
 
	@Test
	public void Test() {

		Parametric testing = new Parametric();
		testing.primero(driver);

	}

	@Test
	public void Test2() {
		Parametric testing = new Parametric();
		testing.comentario(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
