package com.parabank.steps;

import java.util.List;

import org.testng.Assert;

import com.microsoft.playwright.Page;
import com.parabank.core.BaseFactory;
import com.parabank.pages.CustomerCarePage;
import com.parabank.pages.HomePage;
import com.parabank.pages.LandingPage;
import com.parabank.utils.Utilities;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	Page page;
	LandingPage landingPage;
	HomePage homePage;
	CustomerCarePage customerCarePage;
	
	@Given("user is on landing page")
	public void user_is_on_landing_page() {
		String browserName=Utilities.getConfigProperty("browser").toString();
		boolean isHeadlessMode=Boolean.parseBoolean(Utilities.getConfigProperty("headlessMode").toString());
		String url=Utilities.getConfigProperty("url").toString();
		page=BaseFactory.initBrowser(browserName, isHeadlessMode);
		page.navigate(url);
		landingPage=new LandingPage(page);
		homePage=new HomePage(page);
		customerCarePage = new CustomerCarePage(page);
	}

	@When("user enters username")
	public void user_enters_username() {
		String userName=Utilities.getConfigProperty("username").toString();
		landingPage.enterUserName(userName);
	}
	
	@And("user enters password")
	public void user_enters_password() {
		String pwd=Utilities.getConfigProperty("password").toString();
		landingPage.enterPassword(pwd);
	}
	
	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		landingPage.clickLoginButton();
	}
	
	@Then("user can see total balance")
	public void user_can_see_total_balance() {
		boolean isvisible=homePage.isTotalBalanceDisplayed();
		Assert.assertTrue(isvisible);
	}
	
	@When("user clicks on contactus")
	public void user_clicks_on_contactus() {
		landingPage.clickContactUs();
	}
	
	@When("user submits contact us form")
	public void user_submits_contact_us_form(DataTable data) {
			
	   List<List<String>> mydata = data.asLists();
	   customerCarePage.submitContactForm(mydata.get(0).get(0), mydata.get(0).get(1), mydata.get(0).get(2), mydata.get(0).get(3));
	}
	@Then("user can see Thanks message")
	public void user_can_see_thanks_message() {
		boolean isvisible=customerCarePage.isThanksMessageDisplayed();
		Assert.assertTrue(isvisible);
	    
	}
}
