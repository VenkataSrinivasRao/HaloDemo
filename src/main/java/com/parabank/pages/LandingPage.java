package com.parabank.pages;

import com.microsoft.playwright.Page;
import com.parabank.core.CoreFunctions;

/**
 * LandingPage represents the initial login page of ParaBank.
 * 
 * This class contains all locators and user actions performed on the landing page,
 * such as entering username, password, clicking login, and navigating to the 
 * Contact Us section.
 */

public class LandingPage {

	private Page page;
	private CoreFunctions functions;
	
	/**
     * Initializes the LandingPage with Playwright Page and CoreFunctions instance.
     *
     * @param page Playwright Page instance used for UI interactions
     */
	
	public LandingPage(Page page) {
		this.page=page;
		this.functions=new CoreFunctions(page);
	}
	
	// Locators for login fields and Contact Us link
	
	private String username="[name='username']";
	private String password="[name='password']";
	private String loginBtn="[value='Log In']";
	private String contactusLink="//a[normalize-space()='Contact Us']";
	
	/**
     * Enters the username in the username input field.
     *
     * @param uname username value
     */
	
	public void enterUserName(String uname) {
		functions.fill(username, uname);
	}
	
	/**
     * Enters the password in the password input field.
     *
     * @param pwd password value
     */
	
	public void enterPassword(String pwd) {
		functions.fill(password, pwd);
	}
	
	/**
     * Clicks the Login button on the landing page.
     */
	
	public void clickLoginButton() {
		functions.click(loginBtn);
	}
	
	/**
     * Clicks the Contact Us link to navigate to the customer care page.
     */
	
	public void clickContactUs () {
		functions.click(contactusLink);
	}
	
}
