package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PayPalSandboxLoginPage
{
	
	WebDriver webDriver;
	WebElement emailField;
	WebElement passwordField;
	WebElement loginButton;
	
	WebDriverWait wait;
	
	public PayPalSandboxLoginPage()
	{
		System.out.println("PayPalLoginPage default constructor");
	}
	
	public PayPalSandboxLoginPage(WebDriver driver)
	{
		System.out.println("PayPalLiveLoginPage constructor");
		webDriver = driver;
		wait = new WebDriverWait(driver,50);
	}
	
	public void enterDetails(String email, String password)
	{
		emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
		passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
		loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnLogin")));
		emailField.clear();
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	

}
