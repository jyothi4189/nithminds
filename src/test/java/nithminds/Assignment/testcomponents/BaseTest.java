package nithminds.Assignment.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import nithminds.Assignment.pages.LandingPage;

public class BaseTest {
	public WebDriver driver;
	 
	public void InitializeDriver() throws IOException {
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\nithminds\\Assignment\\resources\\global.properties");
		
		Properties p=new Properties();
		p.load(fis);
		String BrowserName=p.getProperty("Browser");
		if(BrowserName.equalsIgnoreCase("chrome")) {
			//ChromeOptions options=new ChromeOptions();
			//options.addArguments("--incognito");
			//options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		
		
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notifications");
		driver=new FirefoxDriver(options);
		}
		else if(BrowserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
	}
	@BeforeMethod

	public LandingPage LaunchBrowser() throws IOException, InterruptedException {
		
		
		
		InitializeDriver();//1
		
		driver.manage().deleteAllCookies();
		
		((ChromeDriver) driver).executeCdpCommand("Network.clearBrowserCookies",new HashMap<>());
		
		((ChromeDriver) driver).executeCdpCommand("Network.clearBrowserCache",new HashMap<>());
		LandingPage LandingPage=new LandingPage(driver);//2
		LandingPage.goTo();
		
		
		return LandingPage;
		
	}
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File(System.getProperty("user.dir")+ "//reports//ScreenShots//" + testCaseName +".png");
		FileUtils.copyFile(source, destination);
		return System.getProperty("user.dir")+ "//reports//ScreenShots//" +testCaseName+ ".png";
	}
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
	
}
