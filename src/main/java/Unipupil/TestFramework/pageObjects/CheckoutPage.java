package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//import Unipupil.TestFramework.pageObjects.CartLineItems.CartCourseAdditionalFeesLineItem;
import Unipupil.TestFramework.pageObjects.CheckoutLineItems.*;
public class CheckoutPage extends UnipupilWebPage
{

	String checkoutPageURL = "https://unipupil.com/en/cart/checkout"; //?action=refresh";
	
	By checkoutTotalLocator = By.cssSelector("td.subtotal > span:nth-of-type(2)");

	WebElement checkoutTotalElement;
	WebElement continueButton;
	
	BigDecimal checkoutTotal;
	
	CheckoutCourseAdditionalFeesLineItem checkoutCourseAddFeesLineItem;
	
	String[] tokens;
	
	public CheckoutPage()
	{
		System.out.println("CheckoutPage default Contructor");
	}
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		System.out.println("CheckoutPage constructor");
	}
	
	
	public void enterAddressDetails()
	{
		 //Delivery Address First Name
        webDriver.findElement(By.id("edit-panes-delivery-delivery-first-name")).sendKeys("Testfirstname");
        
        //Delivery Address Last Name
        webDriver.findElement(By.id("edit-panes-delivery-delivery-last-name")).sendKeys("Testlastname");
        
        //Delivery Address Company
        webDriver.findElement(By.id("edit-panes-delivery-delivery-company")).sendKeys("Test Company");
        
        //Delivery Address Street
        webDriver.findElement(By.id("edit-panes-delivery-delivery-street1")).sendKeys("Test Street");
        
        //Delivery Address City
        webDriver.findElement(By.id("edit-panes-delivery-delivery-city")).sendKeys("Dublin");
        
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        // Select Country
        Select countryMenu = new Select(webDriver.findElement(By.id("edit-panes-delivery-delivery-country")));
        countryMenu.selectByVisibleText("Ireland");
        
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        // Select State
        Select stateProvinceMenu = new Select(webDriver.findElement(By.id("edit-panes-delivery-delivery-zone")));
        stateProvinceMenu.selectByVisibleText("Co. Dublin");
        
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //Delivery Address Postal Code
        webDriver.findElement(By.id("edit-panes-delivery-delivery-postal-code")).sendKeys("2");
        
        //Delivery Address Phone Number
        webDriver.findElement(By.id("edit-panes-delivery-delivery-phone")).sendKeys("012345678");
        
        //Copy delivery information to billing information
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.id("edit-panes-billing-copy-address")).click();

        try
        {
        	Thread.sleep(10000);
        }
        catch(InterruptedException ie)
        {
        	ie.printStackTrace();
        }
         
    }
		
	public void findWebElements()
	{
		String checkoutTotalText;
		checkoutTotalElement = webDriver.findElement(checkoutTotalLocator);
		checkoutTotalText = checkoutTotalElement.getText();
		System.out.println("checkoutTotalText: "+checkoutTotalText);
		checkoutTotal = new BigDecimal(checkoutTotalText.replaceAll("[€$£,a-zA-Z\\s]+", ""));
		System.out.println("checkoutTotal: "+checkoutTotal);
	}
	
	public BigDecimal getCheckoutTotal()
	{
		return checkoutTotal;
	}
	
	
	public void reviewOrder()
	{
		continueButton = webDriver.findElement(By.id("edit-continue"));
		continueButton.click();
	}		
		
		
}
