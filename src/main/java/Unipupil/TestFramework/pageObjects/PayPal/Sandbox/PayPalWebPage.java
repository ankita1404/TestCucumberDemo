package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;


public class PayPalWebPage
{
	WebElement ppSummaryAmountElement;
	WebElement ppSummaryTotalElement;

	By ppSummaryAmountElementLocator = By.cssSelector("#miniCart > ol > li > ul > li > span.amount");
	By ppSummaryTotalElementLocator = By.cssSelector("#miniCart > div.wrap.items.totals.item1 > ul > li > span");

	//String ppSumAmtXpath = ".//*[@id='miniCart']/ol/li/ul/li/span[2]";
    //String ppSumTotalXpath = ".//*[@id='miniCart']/div[2]/ul/li/span";


	String ppSummaryAmount;
	String ppSummaryTotal;
	
	WebDriver webDriver;
	
	public PayPalWebPage()
	{
		System.out.println("PayPalWebPage default constructor");
	}
	
	public PayPalWebPage(WebDriver driver)
	{
		System.out.println("PayPalWebPage constructor");
		webDriver = driver;
	}
	
	public void findSummaryWebElements()
	{
		WebElement ppSummaryAmountElement = webDriver.findElement(ppSummaryAmountElementLocator);
		ppSummaryAmount = ppSummaryAmountElement.getText();
		WebElement ppSummaryTotalElement = webDriver.findElement(ppSummaryTotalElementLocator);
		ppSummaryTotal = ppSummaryTotalElement.getText();
		
	}
	
	public String getSummaryAmount()
	{
		return ppSummaryAmount;
	}
	
	public String getSummaryTotal()
	{
		return ppSummaryTotal;
	}
	
}
