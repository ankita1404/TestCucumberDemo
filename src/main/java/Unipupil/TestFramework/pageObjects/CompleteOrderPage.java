package Unipupil.TestFramework.pageObjects;

import java.util.Date;
import org.joda.time.*;
/*import org.joda.time.base.*;
import org.joda.time.chrono.*;
import org.joda.time.convert.*;
import org.joda.time.field.*;
import org.joda.time.tz.*;*/
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CompleteOrderPage extends UnipupilWebPage
{
	WebElement completeOrderTitleElement;
    WebElement orderCompleteMessageElement;
    WebElement orderStatusLink;
    
    String completeOrderTitleXpath = ".//*[@id='page-title']/div/h1/span[2]";
    String orderStatusLinkXpath = ".//*[@id='block-system-main']/div/p[2]/a[2]";
    String orderCompleteMsgXpath = ".//*[@id='block-system-main']/div/p[1]";
    
    String completeOrderPageURL = "https://unipupil.com/en/cart/checkout/complete";
    
    String userNumber = "29999";
    String orderNumber;
    String orderCompleteMessage;
    String paymentOrderHistoryURL;
    String completeOrderTitle;
    
  //DateFormat dateFormat;
  	//SimpleDateFormat simpleDateFormat;
  	DateTimeFormatter dateTimeFormat;
  	Date date;
  	DateTime purchaseDate;
  	//DateTime endDate;
	
	public CompleteOrderPage()
	{
		System.out.println("CompleteOrderPage default constructor");
	}
	
	public CompleteOrderPage(WebDriver driver)
	{
		super(driver);
		System.out.println("CompleteOrderPage constructor");
	}
	
	public void findCompleteOrderPageWebElements()
	{
		completeOrderTitleElement = webDriver.findElement(By.xpath(completeOrderTitleXpath));
		completeOrderTitle = completeOrderTitleElement.getText();
		System.out.println("completeOrderTitle "+completeOrderTitle);
        orderCompleteMessageElement = webDriver.findElement(By.xpath(orderCompleteMsgXpath));
        orderCompleteMessage = orderCompleteMessageElement.getText();
        System.out.println("orderCompleteMessage"+orderCompleteMessage);
        String[] tokens = orderCompleteMessage.split("\\s");
        orderNumber = tokens[tokens.length-1];
        
        orderNumber = orderNumber.substring(0,orderNumber.length()-1);
	}
	
	public void goToPaymentOrderHistory()
	{    
        orderStatusLink = webDriver.findElement(By.xpath(orderStatusLinkXpath));
        orderStatusLink.click();
	}
	
	public String getcompleteOrderPageURL()
	{
		return completeOrderPageURL;
	}
	
	public String getOrderNumber()
	{
		return orderNumber;
	}
	
	public String getCompleteOrderTitle()
	{
		return completeOrderTitle;
	}
	
	public String getOrderCompleteMessage()
	{
		return orderCompleteMessage;
	}
	
	public String getDate()
	{
		date = new Date();
	    purchaseDate = new DateTime(date);
	    dateTimeFormat = DateTimeFormat.forPattern("dd/MM/yyyy");
	    String dateString = dateTimeFormat.print(purchaseDate);
	    return dateString;
	}
	
	public void myMethod()
	{
		System.out.println("myMethod");
	}
	
}
