package Unipupil.TestFramework.pageObjects.CheckoutLineItems;

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

public class CheckoutLineItem 
{
	WebDriver webDriver;
	
	WebElement cartProductName;
    WebElement cartProductUnitPriceElement;
    WebElement cartLinePriceElement;
    WebElement cartLineQuantityElement;
	
	BigDecimal cartLineQuantity; 
	
	String[] tokens;
	
	public CheckoutLineItem()
	{
		System.out.println("CheckoutLineItem default constructor");
	}
	
	public CheckoutLineItem(WebDriver driver)
	{
		System.out.println("CheckoutLineItem constructor");
		webDriver = driver;
	}
}
