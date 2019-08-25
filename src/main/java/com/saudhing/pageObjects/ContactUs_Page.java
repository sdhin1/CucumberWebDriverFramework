package com.saudhing.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;
import junit.framework.Assert;

public class ContactUs_Page extends BasePage{
	
	@FindBy(name = "first_name")
	public WebElement textfield_FirstName;
	
	@FindBy(name = "last_name")
	public WebElement textfield_LastName;
	
	@FindBy(name = "email")
	public WebElement textfield_Email_Address;
	
	@FindBy(name = "message")
	public WebElement textfield_Comments;
	
	@FindBy(xpath = "//input[@value='SUBMIT']")
	public WebElement button_Submit;
	
	@FindBy(xpath = "//input[@value='RESET']")
	public WebElement button_Reset;

	public ContactUs_Page() throws IOException {
		super();
	}
	
	public ContactUs_Page getContactUsPage() throws IOException {
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterFirstName() throws Exception {
		WaitUntilWebElementIsVisible(textfield_FirstName);
		sendKeysToWebElement(textfield_FirstName, "Tom");
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterLastName(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_LastName, data.get(row).get(column));
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterEmailAddress(String email) throws Exception {
		sendKeysToWebElement(textfield_Email_Address, email);
		return new ContactUs_Page();
	}
	
	public ContactUs_Page enterComments(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_Comments, data.get(row).get(column));
		return new ContactUs_Page();
	}
	
	public ContactUs_Page clickOnSubmitButton() throws Exception {
		waitAndClickElement(button_Submit);
		return new ContactUs_Page();
	}
	
	public ContactUs_Page confirmContactUsFormSubmissionSuccessful() throws IOException {
		WebElement thanksContactUsPage = getDriver().findElement(By.xpath("//*[@id='contact_reply']/h1"));
		WaitUntilWebElementIsVisible(thanksContactUsPage);
		Assert.assertEquals("Thank You for your Message!", thanksContactUsPage.getText());
		return new ContactUs_Page();
	}

}
