package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Unipupil.TestFramework.utilities.FindElement;


public class PayPalLoginPage extends PayPalWebPage
{
	
	
	WebElement ppBillingModule;
	WebElement ppEmailInput;
	WebElement ppPasswordInput;
	WebElement ppSubmitButton;
	
	WebDriverWait wait;
	
	By billingModuleSelector = By.cssSelector("div#billingModule > div:nth-of-type(1)");
	By submitButtonLocator = By.cssSelector("input#submitLogin");
	
	public PayPalLoginPage()
	{
		System.out.println("PayPalLoginPage default constructor");
	}
	
	public PayPalLoginPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalLoginPage constructor");
	}
	
	public void login(String email, String password)
	{
		wait = new WebDriverWait(webDriver,30);
		ppBillingModule = wait.until(ExpectedConditions.presenceOfElementLocated(billingModuleSelector));
        ppBillingModule.click();
        
        System.out.println("Passed credentials:"+email+", "+password);
        
        ppEmailInput  = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_email")));
        ppEmailInput.sendKeys(email);
        System.out.println("Input username: "+ppEmailInput.getAttribute("value"));
        
        ppPasswordInput  = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_password")));
        ppPasswordInput.sendKeys(password);
        System.out.println("Input password: "+ppPasswordInput.getAttribute("value"));
        
        ppSubmitButton  = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitLogin")));
        ppSubmitButton.click();
	}
	
	public void login()
	{
		wait = new WebDriverWait(webDriver,20);
		ppBillingModule = wait.until(ExpectedConditions.presenceOfElementLocated(billingModuleSelector));
        ppBillingModule.click();
        /*try{
        	System.out.println("Pausing program for manual login");
        	//JOptionPane.showMessageDialog(null, "Please input PayPal username and password", "InfoBox: Login action", JOptionPane.INFORMATION_MESSAGE);
        	Thread.sleep(20000);
        }
        catch(InterruptedException ie){
        	ie.printStackTrace();
        }*/
        ppSubmitButton  = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("submitLogin")));
        ppSubmitButton.click();
	}
	

}
