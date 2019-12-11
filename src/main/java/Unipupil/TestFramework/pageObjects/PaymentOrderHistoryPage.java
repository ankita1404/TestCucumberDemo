package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;


public class PaymentOrderHistoryPage extends UnipupilWebPage
{
	WebElement paymentOrderHistoryHeaderElement;
	//WebElement orderStatusLink; 
	//WebElement paymentOrderHistoryLineQuantityElement;
	//WebElement orderConfirmationProductName;
	//WebElement orderConfirmationAdditionalFeesTitle;
	//WebElement orderConfirmationInstitutionTitle;
	//WebElement orderConfirmationSKU;
	//WebElement orderConfirmationProdUnitPriceElement;
	//WebElement orderConfirmationLinePriceElement;
	WebElement paymentOrderHistorySubTotalElement;
	WebElement paymentOrderHistoryTotalElement;
	WebElement myAccountLink;
	
	String pmtOrderHistHdrXpath = ".//*[@id='page-title']/div/h1/span[2]";
	/*String orderConfirmationProdNameXpath = ".//*[@id='order-pane-products']/table[2]/tbody/tr/td[1]/a";
	String orderHistAddFeesDescriptionXpath = "";
	String orderConfirmationLineQuantityXpath = ".//*[@id='order-pane-products']/table[2]/tbody/tr/td[2]";
	String orderConfirmationProdUnitPriceXpath = ".//*[@id='order-pane-products']/table[2]/tbody/tr/td[3]/span";
	String orderConfirmationLinePriceXpath = ".//*[@id='order-pane-products']/table[2]/tbody/tr/td[4]/span";
	//String orderConfirmationSubtotalXpath = ".//*[@id='order-pane-line_items']/table/tbody/tr[1]/td[2]/span";*/
	String paymentOrderHistoryTotalXpath = ".//*[@id='order-pane-line_items']/table/tbody/tr[2]/td[2]/span";
	String userNumber = "29999";
	String orderNumber;
	
	String paymentOrderHistoryURL;
	String paymentOrderHistoryHeader;
	
	/*String basicFeeString;
	String additionalFeeString;
	String courseName;*/
	//String grossFeesString;
	
	BigDecimal paymentOrderHistoryTotal;
	
	public PaymentOrderHistoryPage()
	{
		System.out.println("PaymentOrderHistoryPage default constructor");
	}
	
	public PaymentOrderHistoryPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PaymentOrderHistoryPage default constructor");
	}
	
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	public String getPaymentOrderHistoryURL()
	{
		paymentOrderHistoryURL = "https://unipupil.com/en/user/"+userNumber+"/orders/"+ orderNumber;
		return paymentOrderHistoryURL;
	}
	
	public void findElements()
	{
		paymentOrderHistoryHeaderElement = webDriver.findElement(By.xpath(pmtOrderHistHdrXpath));
		paymentOrderHistoryHeader = paymentOrderHistoryHeaderElement.getText();
		paymentOrderHistoryTotalElement = webDriver.findElement(By.xpath(paymentOrderHistoryTotalXpath));
		//grossFeesString = paymentOrderHistoryTotalElement.getText();
		String paymentOrderHistoryTotalText = paymentOrderHistoryTotalElement.getText().toUpperCase().replaceAll("[€$£,a-zA-Z\\s]","");
		System.out.println(paymentOrderHistoryTotalText);
		paymentOrderHistoryTotal = new BigDecimal(paymentOrderHistoryTotalText.trim());
		
	}
	
	public String getPaymentOrderHistoryHeader()
	{
		return paymentOrderHistoryHeader;
	}
	
	public BigDecimal getPaymentOrderHistoryTotal()
	{
		return paymentOrderHistoryTotal;
	}
	
	public void goToMyAccount()
	{
		myAccountLink = webDriver.findElement(By.linkText("My Account"));
		myAccountLink.click();
	}
	
}
