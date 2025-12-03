package com.parabank.pages;

import com.microsoft.playwright.Page;
import com.parabank.core.CoreFunctions;

/**
 * CustomerCarePage represents the Contact Us page of the ParaBank application.
 * 
 * This class contains locators and reusable methods for interacting with
 * fields on the Customer Care form, such as entering name, email, phone, and
 * message details. It also provides a method to verify the success message 
 * after submitting the form.
 */

public class CustomerCarePage {

	private Page page;
	private CoreFunctions functions;
	
	/**
     * Constructor initializes the Playwright Page and CoreFunctions utility.
     *
     * @param page Playwright Page instance used for interacting with UI elements
     */
	
	public CustomerCarePage(Page page) {
		this.page=page;
		this.functions=new CoreFunctions(page);
	}
	
	// Locators for form elements
	
	private String name="#name";
	private String email="#email";
	private String phone="#phone";
	private String message="#message";
	private String sendToCustomerCareBtn="input[value='Send to Customer Care']";
	private String thanksmessage="//p[contains(normalize-space(), 'Thank you')]";
	
	/**
     * Enters user's name in the name field.
     *
     * @param userName Name of the user
     */
	
	public void enterName(String userName) {
		functions.fill(name,userName);
    }
    
	/**
     * Enters user's email in the email field.
     *
     * @param userEmail Email address to enter
     */
	
	public void enterEmail(String userEmail) 
    {
		functions.fill(email,userEmail);
    }
    
	/**
     * Enters user's phone number in the phone field.
     *
     * @param userPhone Phone number of the user
     */
	
	public void enterPhone(String userPhone) {
    	functions.fill(phone,userPhone);
    }
    
	 /**
     * Enters user message in the message area.
     *
     * @param userMessage Message text to send to customer care
     */
	
	public void enterMessage(String userMessage) {
        functions.fill(message,userMessage);
    }
    
	 /**
     * Clicks on the "Send to Customer Care" button.
     */
	
	public void clickSendToCustomerCareButton() {
        functions.click(sendToCustomerCareBtn);
    }
	
	 /**
     * Submits the complete contact form with all required fields.
     *
     * @param name    User's name
     * @param email   User's email
     * @param phone   User's phone number
     * @param message Message to submit
     */
	
	public void submitContactForm(String name, String email, String phone, String message) {
        enterName(name);
        enterEmail(email);
        enterPhone(phone);
        enterMessage(message);
        clickSendToCustomerCareButton();
    }
	
	 /**
     * Checks whether the Thank You confirmation message is visible.
     *
     * @return true if the message is displayed, false otherwise
     */
	
	public boolean isThanksMessageDisplayed() {
		return functions.isDisplayed(thanksmessage);
	}
}
