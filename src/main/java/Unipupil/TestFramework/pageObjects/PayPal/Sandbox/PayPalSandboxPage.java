package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PayPalSandboxPage
{
	//List<WebElement> amountElements;
	WebElement amountElement;
	//List<WebElement> statusElements;
	WebElement statusElement;
	
	WebDriver webDriver;
	WebElement loginButton;
	WebElement logoutButton;
	
	//By feeLocator = By.cssSelector("td.cur_val");
	By feeLocator = By.cssSelector("table.table.table-striped.table-hover > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > a");
	//By statusLocator = By.cssSelector("div.wrapPaymentStatus");
	By statusLocator = By.cssSelector("table.table.table-striped.table-hover > tbody > tr:nth-of-type(1) > td:nth-of-type(2) > a > ul > li");
	//By loginLocator = By.cssSelector("div#header-buttons > a:nth-of-type(1)");
	By loginLocator = By.cssSelector("a#ul-btn");
	//By logoutLocator = By.cssSelector("div#navGlobal > ul > li:nth-of-type(1) > a");
    //By logoutLocator = By.linkText("Log Out");
	By logoutLocator = By.cssSelector("div.mer-logout-wrapper.hidden-xs > a");
    
	WebDriverWait wait;
	
	
	
	public PayPalSandboxPage()
	{
		System.out.println("PayPalLivePage default constructor");
	}
	
	public PayPalSandboxPage(WebDriver driver)
	{
		System.out.println("PayPalLivePage constructor");
		webDriver = driver;
		wait = new WebDriverWait(driver,30);
	}
	
	public void login()
	{
		System.out.println("'login' running");
		/*try
		{
		loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log In")));
		}
		catch(Exception ex)
		{
			loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Einloggen")));
		}*/
		loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(loginLocator));
		loginButton.click();
	}
	
	public void logout()
	{
		System.out.println("'logout' running");
		logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
		logoutButton.click();
	}

}
