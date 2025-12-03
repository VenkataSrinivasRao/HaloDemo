package com.parabank.core;

import com.microsoft.playwright.Page;

/**
 * CoreFunctions provides commonly used Playwright wrapper actions.
 * 
 * This class abstracts basic UI interactions such as clicking, filling input fields,
 * and verifying element visibility, making test scripts cleaner and more readable.
 * 
 * Each method relies on Playwright's locator API for fast and reliable interactions.
 */

public class CoreFunctions {

	private Page page;

	/**
     * Constructor initializes CoreFunctions with the given Playwright Page.
     *
     * @param page Playwright Page object used to perform UI actions.
     */
	
	public CoreFunctions(Page page) {
        this.page = page;
    }
    
	 /**
     * Clicks on the element identified by the given locator.
     *
     * @param locator Playwright selector used to identify the element
     */
	
	public void click(String locator) {
        page.locator(locator).click();
    }
    
	 /**
     * Fills the specified text into an input field identified by the given locator.
     *
     * @param locator Playwright selector for the input field
     * @param text    Text value to be entered
     */
	
	public void fill(String locator, String text) {
        page.locator(locator).fill(text);
    }
    
	/**
     * Checks if the element identified by the given locator is visible on the page.
     *
     * @param locator Playwright selector for the element
     * @return true if the element is visible, false otherwise
     */
	
	public boolean isDisplayed(String locator) {
    	return page.locator(locator).isVisible();
    }
}
