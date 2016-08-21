package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import browserAppLauncher.BrowserAppLauncher;


//This class stored all locators (elements) and methods of 'using My Vodafone' page
public class UsingMyVodafonePage {
	
	public String getPageTitle() {
		return BrowserAppLauncher.driver.getTitle();
    }
	
	public String getPageURL() {
		return BrowserAppLauncher.driver.getCurrentUrl();
    }
	
	
	By forFamiliesLinktext = By.linkText("For Families");
	By loginButton = By.xpath("//a[@title='Login']");
	
	public void moveMouseOnForFamiliesLinktext() {
		Actions act=new Actions(BrowserAppLauncher.driver);
		act.moveToElement(BrowserAppLauncher.driver.findElement(forFamiliesLinktext)).perform();
	}
	
	public void clickOnLoginButton() {
		BrowserAppLauncher.driver.findElement(loginButton).click();
	}

}
