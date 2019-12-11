package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;

import Unipupil.TestFramework.pageObjects.ReviewOrderLineItems.ReviewOrderCourseAdditionalFeesLineItem;


public class ReviewOrderPage extends UnipupilWebPage 
{
	
	String reviewOrderURL = "https://unipupil.com/en/cart/checkout/review";
	
	By reviewOrderSubtotalLocator = By.cssSelector("div#block-system-main > div > table > tbody > tr:nth-of-type(12) > td:nth-of-type(2)");
    By reviewOrderTotalLocator = By.cssSelector("div#block-system-main > div > table > tbody > tr:nth-of-type(13) > td:nth-of-type(2)");
    By reviewOrderHeaderLocator = By.cssSelector("h1#page-title > div > h1 > span:nth-of-type(2)");
    
    WebElement reviewOrderHeaderElement;
    WebElement reviewOrderSubTotalElement;
	WebElement reviewOrderTotalElement;
	WebElement submitButton;
	
	BigDecimal reviewOrderSubTotal;
	BigDecimal reviewOrderTotal;
	
	ReviewOrderCourseAdditionalFeesLineItem reviewOrderCourseAddFeesLineItem;
	
	String reviewOrderHeader;
	String reviewOrderTotalText;
	
	//WebDriver driver;
	
	public ReviewOrderPage()
	{
		System.out.println("ReviewOrderPage default constructor");
	}
	
	public ReviewOrderPage(WebDriver driver)
	{
		super(driver);
		System.out.println("ReviewOrderPage constructor");
	}
	
	public void findWebElements()
	{
		reviewOrderHeaderElement = webDriver.findElement(reviewOrderHeaderLocator);
		
        reviewOrderHeader = reviewOrderHeaderElement.getText();
        System.out.println(reviewOrderHeader);
        
		reviewOrderSubTotalElement = webDriver.findElement(reviewOrderSubtotalLocator);
		System.out.println(reviewOrderSubTotalElement.getText());
		String reviewOrderSubTotalText = reviewOrderSubTotalElement.getText().toUpperCase().replaceAll("[€$£,a-zA-Z\\s]+","");
		System.out.println(reviewOrderSubTotalText);
		reviewOrderSubTotal = new BigDecimal(reviewOrderSubTotalText.trim());
		
		reviewOrderTotalElement = webDriver.findElement(reviewOrderTotalLocator);
		reviewOrderTotalText = reviewOrderTotalElement.getText();
		System.out.println(reviewOrderTotalText);
		String reviewOrderTotalText = reviewOrderTotalElement.getText().toUpperCase().replaceAll("[€$£,a-zA-Z\\s]","");
		System.out.println(reviewOrderTotalText);
		reviewOrderTotal = new BigDecimal(reviewOrderTotalText.trim());
	}
	
	public String getReviewOrderHeader()
	{
		return reviewOrderHeader;
	}
	
	public BigDecimal getReviewOrderSubTotal()
	{
		return reviewOrderSubTotal;
	}
	
	public BigDecimal getReviewOrderTotal()
	{
		return reviewOrderTotal;
	}
	
	
	public void submitOrder()
	{
		submitButton = webDriver.findElement(By.id("edit-submit"));
		submitButton.click();
	}	
	
	public String getReviewOrderTotalText()
	{
		return reviewOrderTotalText;
	}
	
	public String getReviewOrderTotalTextNoEUR()
	{
		return reviewOrderTotalText.split("EUR, ")[1];
	}
	

}
