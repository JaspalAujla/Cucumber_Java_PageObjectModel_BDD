package stepDefinition;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObject.LoginHandlerPage;
import pageObject.UsingMyVodafonePage;
import pageObject.VodafoneLandingPage;

public class LoginStepDefinition {
	
	VodafoneLandingPage vodafoneLandingPage = new VodafoneLandingPage();
	UsingMyVodafonePage usingMyVodafonePage = new UsingMyVodafonePage();
	LoginHandlerPage loginHandlerPage = new LoginHandlerPage();
		
		
	@When("^I click the My Vodafone link$")
	public void i_click_the_My_Vodafone_link() throws Throwable {
		vodafoneLandingPage.clickOnMyVodafoneLinktext();
	}
	
	@Then("^I should see the 'using MyVodafone' page$")
	public void i_should_see_the_using_MyVodafone_page() throws Throwable {
		Assert.assertTrue("Actual URL is: "+usingMyVodafonePage.getPageURL(), usingMyVodafonePage.getPageURL().contains("using-myvodafone/"));
	}	
	
	@When("^I click the Login button$")
	public void i_click_the_Login_button() throws Throwable {
		usingMyVodafonePage.moveMouseOnForFamiliesLinktext();
		usingMyVodafonePage.clickOnLoginButton();
	}
	
	@Then("^I should see the 'login Handler' page$")
	public void i_should_see_the_login_Handler_page() throws Throwable {
		Assert.assertTrue("Actual title is: "+loginHandlerPage.getPageTitle(), loginHandlerPage.getPageTitle().contains("Sign in to My Vodafone"));
	}
	
	@When("^I try to login with invalid credentials$")
	public void i_try_to_login_with_invalid_credentials() throws Throwable {
		loginHandlerPage.setLoginUsername("abcde");
		loginHandlerPage.setLoginPassword("12345");
		loginHandlerPage.clickOnSignInButton();
	}
	
	@Then("^I should see the notice \"(.*?)\"$")
	public void i_should_see_the_notice(String expectedErrorMessage) throws Throwable {
		Assert.assertTrue("Actual error message is: "+loginHandlerPage.getLoginErrorMessage(), loginHandlerPage.getLoginErrorMessage().contains(expectedErrorMessage));
	}

}
