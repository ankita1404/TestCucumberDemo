package Unipupil.TestFramework.pageObjects.PayPal.Live;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PayPalLivePage
{
	List<WebElement> amountElements;
	List<WebElement> statusElements;
	
	WebDriver webDriver;
	WebElement loginButton;
	WebElement logoutButton;
	
	By feeLocator = By.cssSelector("td.cur_val");
	By statusLocator = By.cssSelector("div.wrapPaymentStatus");
	By loginLocator = By.cssSelector("div#header-buttons > a:nth-of-type(1)");
	//By logoutLocator = By.cssSelector("div#navGlobal > ul > li:nth-of-type(1) > a");
    By logoutLocator = By.linkText("Log Out");
    
	WebDriverWait wait;
	
	
	
	public PayPalLivePage()
	{
		System.out.println("PayPalLivePage default constructor");
	}
	
	public PayPalLivePage(WebDriver driver)
	{
		System.out.println("PayPalLivePage constructor");
		webDriver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	public void login()
	{
		System.out.println("'login' running");
		//loginButton = webDriver.findElement(By.id("ul-btn"));
		try
		{
		loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log In")));
		}
		catch(Exception ex)
		{
			loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Einloggen")));
		}
		//loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(loginLocator));
		loginButton.click();
	}
	
	public void logout()
	{
		System.out.println("'logout' running");
		logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
		logoutButton.click();
	}

}
