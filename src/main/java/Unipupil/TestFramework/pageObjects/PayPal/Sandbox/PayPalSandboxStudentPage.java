package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayPalSandboxStudentPage extends PayPalSandboxPage
{
	WebElement grossFeeElement;
	
	BigDecimal grossFee;
	BigDecimal agentCommission;
	BigDecimal institutionCommission;
	
	By logoutLocator = By.cssSelector("div.mer-logout-wrapper.hidden-xs > a");
	
	public PayPalSandboxStudentPage()
	{
		System.out.println("PayPalLiveStudentPage default constructor");
	}
	
	public PayPalSandboxStudentPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalLiveStudentPage constructor");
	}
	
	public BigDecimal getGrossFee()
	{
		amountElement = wait.until(ExpectedConditions.presenceOfElementLocated(feeLocator));
		//System.out.println(amountElements.size());
		//grossFeeElement = amountElements.get(0);
		System.out.println("grossFeeElement: "+amountElement.getText()); //grossFeeElement.getText());
		//grossFee = new BigDecimal(amountElements.get(0).getText().toUpperCase().replaceAll("[-€,EUR\\s]+",""));
		grossFee = new BigDecimal(amountElement.getText().toUpperCase().replaceAll("[-€,EUR\\s]+",""));
		return grossFee;
	}
	
	public String getPaymentStatus()
	{
		String paymentStatus;
		statusElement = wait.until(ExpectedConditions.presenceOfElementLocated(statusLocator));
		//WebElement statusElement = statusElements.get(0);
		paymentStatus = statusElement.getText().toUpperCase().trim().toLowerCase();
		return paymentStatus;
	}
	
}