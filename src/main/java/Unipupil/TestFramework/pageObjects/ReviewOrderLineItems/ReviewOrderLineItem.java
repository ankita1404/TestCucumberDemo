package Unipupil.TestFramework.pageObjects.ReviewOrderLineItems;

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

public class ReviewOrderLineItem 
{
	WebDriver webDriver;
	
	WebElement cartProductName;
    WebElement cartProductUnitPriceElement;
    WebElement cartLinePriceElement;
    WebElement cartLineQuantityElement;
	
	BigDecimal cartLineQuantity; 
	
	String[] tokens;
	
	public ReviewOrderLineItem()
	{
		System.out.println("CartLineItem default constructor");
	}
	
	public ReviewOrderLineItem(WebDriver driver)
	{
		System.out.println("CartLineItem constructor");
		webDriver = driver;
	}
}
