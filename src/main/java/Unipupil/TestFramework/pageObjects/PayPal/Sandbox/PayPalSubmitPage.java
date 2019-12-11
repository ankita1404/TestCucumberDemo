package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Unipupil.TestFramework.utilities.FindElement;


public class PayPalSubmitPage extends PayPalWebPage
{
    By reviewInfoHdrLocator = By.cssSelector("div#parentSlider > fieldset > h2");
    By submitButtonLocator = By.cssSelector("input.button.primary.default.parentSubmit");
    //By submitButtonLocator = By.className("button.primary.default.parentSubmit");
    //By submitButtonLocator = By.cssSelector("input#submit.x");
    //By SubmitButtonLocator = By.id("submit.x");
    //By submitButtonLocator = By.xpath(".//input[@id='submit.x']");
    
	String reviewInfoHeader;
	
	WebElement reviewInfoHeaderElement;
	WebElement ppPayButton;
	
	WebDriverWait wait;
	
	public PayPalSubmitPage()
	{
		System.out.println("PayPalSubmitPage default constructor");
	}
	
	public PayPalSubmitPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalSubmitPage constructor");
		wait = new WebDriverWait(driver,30);
	}
	
	public String getReviewInfoHeader()
	{
		reviewInfoHeaderElement = wait.until(ExpectedConditions.presenceOfElementLocated(reviewInfoHdrLocator));
		//WebElement reviewInfoHeaderElement = FindElement.findElement(webDriver, reviewInfoHdrLocator);
		reviewInfoHeader = reviewInfoHeaderElement.getText();
		return reviewInfoHeader;
	}
	
	public void confirmPayment()
	{
		//ppPayButton = wait.until(ExpectedConditions.presenceOfElementLocated(submitButtonLocator));
		ppPayButton = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButtonLocator));
		//WebElement ppPayButton = FindElement.findElement(webDriver, submitButtonLocator);
        ppPayButton.click();
	}

}
