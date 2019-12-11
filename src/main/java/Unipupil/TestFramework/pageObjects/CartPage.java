package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
/*import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.List;*/

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;*/

//import Unipupil.TestFramework.pageObjects.UnipupilWebPage;
//import Unipupil.TestFramework.pageObjects.CartLineItems.CartCourseAdditionalFeesLineItem;

public class CartPage extends UnipupilWebPage {
	
	//WebDriver webDriver;
	
	String cartURL = "https://unipupil.com/en/cart";
	//String cartURL = "http://159.8.254.77/en/cart";
	
    WebElement cartSubTotalElement;
    WebElement checkoutButton;
    
    //CartCourseAdditionalFeesLineItem cartCourseAddFeesLineItem;
    
    By cartSubTotalLocator = By.cssSelector("td.subtotal > span:nth-of-type(2)");
    By checkoutButtonLocator = By.cssSelector("input[value='Checkout']");
    
	String[] tokens;
	
	BigDecimal cartSubTotal;
	
	public CartPage()
	{
		System.out.println("CartPage default constructor");
	}
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		System.out.println("CartPage constructor");
	}
	
	public void findWebElements(WebDriver driver)
	{
		cartSubTotalElement = driver.findElement(cartSubTotalLocator);
		cartSubTotal = new BigDecimal(cartSubTotalElement.getText().toUpperCase().replaceAll("[€£$,a-zA-Z\\s]+", ""));
	}
	
	public BigDecimal getCartSubTotal()
	{
		return cartSubTotal;
	}
	
	public void goToCheckout()
	{
		//WebElement checkoutButton = webDriver.findElement(By.id("edit-checkout--2"));
		WebElement checkoutButton = webDriver.findElement(checkoutButtonLocator); 
        checkoutButton.click();
		
	}
    

}
