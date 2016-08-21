package pageObject;

import org.openqa.selenium.By;

import browserAppLauncher.BrowserAppLauncher;


//This class stored all locators (elements) and methods of 'Vodafone Landing' page
public class VodafoneLandingPage {
	
	public String getPageTitle() {
		return BrowserAppLauncher.driver.getTitle();
    }
	
	public String getPageURL() {
		return BrowserAppLauncher.driver.getCurrentUrl();
    }
	
	
	By myVodafoneLinktext = By.linkText("My Vodafone");
	
	public void clickOnMyVodafoneLinktext() {
		BrowserAppLauncher.driver.findElement(myVodafoneLinktext).click();
	}

}
