package stepDefinition;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import browserAppLauncher.BrowserAppLauncher;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class CommonStepDefinition {
		
	BrowserAppLauncher mba = new BrowserAppLauncher();
	
	@Before
	public void launchBrowserAndApp() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\manageBrowserAppWaits\\ManageBrowserAppWaits.properties");
		prop.load(fis);		
		mba.launchBrowser(prop.getProperty("browserName"));
		mba.maximizeBrowser();
		mba.setImplicitWait(prop.getProperty("implicitWait"));
		mba.setPageLoadTimeout(prop.getProperty("pageLoadTimeOut"));
		prop.clear();
	}	
	
	@Given("^I am on the vodafone landing page$")
	public void i_am_on_the_vodafone_landing_page() throws Throwable {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\manageBrowserAppWaits\\ManageBrowserAppWaits.properties");
		prop.load(fis);	
		mba.launchApp(prop.getProperty("baseURL"));
		prop.clear();
	}
	
	@Given("^I am on the vodafone login page$")
	public void i_am_on_the_vodafone_login_page() throws Throwable {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\manageBrowserAppWaits\\ManageBrowserAppWaits.properties");
		prop.load(fis);	
		mba.launchApp(prop.getProperty("loginPageURL"));
		prop.clear();
	}
	
	@After
    public void tearDown(Scenario scenario) {
		mba.tearDown(scenario);
    }

}
