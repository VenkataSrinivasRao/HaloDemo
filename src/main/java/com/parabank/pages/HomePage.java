package com.parabank.pages;

import com.microsoft.playwright.Page;
import com.parabank.core.CoreFunctions;

/**
 * HomePage represents the page displayed after a successful login 
 * into the ParaBank application.
 * 
 * This class contains actions and validations related to the Home page,
 * such as verifying whether the Total Balance section is visible.
 */

public class HomePage {

	private Page page;
	private CoreFunctions functions;
	
	 /**
     * Constructor used to initialize HomePage with Playwright Page 
     * and CoreFunctions object.
     *
     * @param page Playwright page instance for interacting with UI elements
     */
	
	public HomePage(Page page) {
		this.page=page;
		this.functions=new CoreFunctions(page);
	}
	
	// Locator for fetching the Total Balance element on the Home page
	
	private String totalBalance="//td[@align='right']//following-sibling::td[1]";
	
	 /**
     * Verifies whether the total balance element is displayed on the Home page.
     *
     * @return true if total balance is visible, otherwise false
     */
	
	public boolean isTotalBalanceDisplayed() {
		return functions.isDisplayed(totalBalance);
	}
}
