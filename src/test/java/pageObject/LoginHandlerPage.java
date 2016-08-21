package pageObject;

import org.openqa.selenium.By;

import browserAppLauncher.BrowserAppLauncher;


//This class stored all locators (elements) and methods of 'Login Handler' page
public class LoginHandlerPage {
	
	public String getPageTitle() {		
		return BrowserAppLauncher.driver.getTitle();
    }
	
	public String getPageURL() {
		return BrowserAppLauncher.driver.getCurrentUrl();
    }
	
	
	By userNameTextbox = By.id("myvfLoginOnlineId");
	By passwordTextbox = By.id("myvfLoginPassword");
	By signInButton = By.id("sign-in-button");
	By loginErrorMessage = By.xpath("//div[@class='submitError']");
	
	public void setLoginUsername(String value) {
		BrowserAppLauncher.driver.findElement(userNameTextbox).sendKeys(value);
	}
	
	public void setLoginPassword(String value) {
		BrowserAppLauncher.driver.findElement(passwordTextbox).sendKeys(value);
	}
	
	public void clickOnSignInButton() {
		BrowserAppLauncher.driver.findElement(signInButton).click();
	}
	
	public String getLoginErrorMessage() {
	    return BrowserAppLauncher.driver.findElement(loginErrorMessage).getText();
	}

}
