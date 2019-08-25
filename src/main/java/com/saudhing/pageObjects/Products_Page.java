package com.saudhing.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends BasePage{
	
	@FindBy(xpath = "//p[text()='Special Offers']")
	public WebElement button_SpecialOffers;
	
	@FindBy(xpath = "//p[text()='New Laptops']")
	public WebElement button_NewLaptops;
	
	@FindBy(xpath = "//button[text()='Proceed']")
	public WebElement button_Proceed_Popup;
	
	@FindBy(xpath = "//div[@class='modal-body']//b[contains(text(), 'NEWCUSTOMER')]")
	public WebElement voucherNumber;

	public Products_Page() throws IOException {
		super();
	}
	
	public Products_Page clickOnProceedButton_Popup() throws IOException, InterruptedException {
		waitAndClickElement(button_Proceed_Popup);
		return new Products_Page();
	}
	
	public String printSpecialOfferVoucherCode() {
		WaitUntilWebElementIsVisible(voucherNumber);
		String voucherCode = voucherNumber.getText();
		System.out.println("Voucher Code: "+ voucherCode);
		return voucherCode;
	}

}
