package com.parabank.pages;

import com.microsoft.playwright.Page;
import com.parabank.core.CoreFunctions;

public class CustomerCarePage {

	private Page page;
	private CoreFunctions functions;
	
	public CustomerCarePage(Page page) {
		this.page=page;
		this.functions=new CoreFunctions(page);
	}
	
	private String name="#name";
	private String email="#email";
	private String phone="#phone";
	private String message="#message";
	private String sendToCustomerCareBtn="input[value='Send to Customer Care']";
	private String thanksmessage="//p[contains(normalize-space(), 'Thank you')]";
	
	public void enterName(String userName) {
		functions.fill(name,userName);
    }
    
    public void enterEmail(String userEmail) 
    {
		functions.fill(email,userEmail);
    }
    
    public void enterPhone(String userPhone) {
    	functions.fill(phone,userPhone);
    }
    
    public void enterMessage(String userMessage) {
        functions.fill(message,userMessage);
    }
    
    public void clickSendToCustomerCareButton() {
        functions.click(sendToCustomerCareBtn);
    }
	
	public void submitContactForm(String name, String email, String phone, String message) {
        enterName(name);
        enterEmail(email);
        enterPhone(phone);
        enterMessage(message);
        clickSendToCustomerCareButton();
    }
	
	public boolean isThanksMessageDisplayed() {
		return functions.isDisplayed(thanksmessage);
	}
}
