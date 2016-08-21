package browserAppLauncher;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import cucumber.api.Scenario;

public class BrowserAppLauncher {
	
	public static WebDriver driver;
	
	public void launchBrowser(String browserName) {
		if(browserName.toLowerCase().contains("firefox"))
		{
			driver = new FirefoxDriver();			
		}
		else if(browserName.toLowerCase().contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowsersDriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.toLowerCase().contains("ie"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\BrowsersDriver\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browserName.toLowerCase().contains("edge"))
		{
			System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\BrowsersDriver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.toLowerCase().contains("safari"))
		{
			driver = new SafariDriver();
		}
    }
	
	public void maximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	
	public void setImplicitWait(String waitTime)
	{
		driver.manage().timeouts().implicitlyWait((int) Integer.parseInt(waitTime), TimeUnit.SECONDS);
	}
	
	public void setPageLoadTimeout(String waitTime)
	{
		driver.manage().timeouts().pageLoadTimeout((int) Integer.parseInt(waitTime), TimeUnit.SECONDS);
	}
	
	public void launchApp(String appURL)
	{
		driver.get(appURL);
	}
	
	public void tearDown(Scenario scenario) 
	{
	    if (scenario.isFailed())
	    {
	    	byte[] screenshotBytes = ((TakesScreenshot) BrowserAppLauncher.driver).getScreenshotAs(OutputType.BYTES);
		    scenario.embed(screenshotBytes, "image/png");
	    }
	    if (driver != null)
		{
			driver.quit();
		}
	}

}
