package Unipupil.TestFramework.pageObjects.PaymentOrderHistoryLineItems;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentOrderHistoryLineItem 
{
	WebDriver webDriver;
	
	WebElement ProductName;
    WebElement cartProductUnitPriceElement;
    WebElement cartLinePriceElement;
    WebElement cartLineQuantityElement;
	
	BigDecimal cartLineQuantity; 
	
	String[] tokens;
	WebDriverWait wait;
	
	public PaymentOrderHistoryLineItem()
	{
		System.out.println("PaymentOrderHistoryLineItem default constructor");
	}
	
	public PaymentOrderHistoryLineItem(WebDriver driver)
	{
		System.out.println("PaymentOrderHistoryLineItem constructor");
		webDriver = driver;
		wait = new WebDriverWait(webDriver,30);
	}
}
