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
import java.util.List;


public class InstalmentSchedule extends UnipupilWebPage {
	
	String cartURL = "https://unipupil.com/en/cart";
	
    List<WebElement> instalmentScheduleLines;
    WebElement instalmentNumberNamePercentElement;
    WebElement instalmentDateElement;
    WebElement instalmentAmountElement;
    WebElement courseTotalLabelElement;
    WebElement courseTotalElement;

    By instalmentScheduleLinesSelector = By.cssSelector("ul.product-description > ul > li:nth-of-type(4) > span");
    By instalmentNumberNamePercentElementLocator = By.cssSelector("");
    By instalmentDateLocator = By.cssSelector("");
    By instalmentAmountLocator = By.cssSelector("");
    By courseTotalLabelLocator = By.cssSelector("");
    By courseTotalLocator = By.cssSelector("");
    
	String[] tokens;
	
	public InstalmentSchedule()
	{
		System.out.println("InstalmentSchedule default constructor");
	}
	
	public InstalmentSchedule(WebDriver driver)
	{
		super(driver);
		System.out.println("InstalmentSchedule constructor");
	}
	
	/*public void findWebElements(WebDriver driver)
	{
		cartSubTotalElement = driver.findElement(cartSubTotalLocator);
		cartSubTotal = new BigDecimal(cartSubTotalElement.getText().toUpperCase().replaceAll("[€,]+", ""));
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
		
	}*/
    

}
