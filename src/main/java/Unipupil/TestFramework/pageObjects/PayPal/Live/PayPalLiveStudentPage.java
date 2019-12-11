package Unipupil.TestFramework.pageObjects.PayPal.Live;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayPalLiveStudentPage extends PayPalLivePage
{
	WebElement grossFeeElement;
	
	BigDecimal grossFee;
	BigDecimal agentCommission;
	BigDecimal institutionCommission;
	
	public PayPalLiveStudentPage()
	{
		System.out.println("PayPalLiveStudentPage default constructor");
	}
	
	public PayPalLiveStudentPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalLiveStudentPage constructor");
	}
	
	public BigDecimal getGrossFee()
	{
		amountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(feeLocator));
		System.out.println(amountElements.size());
		grossFeeElement = amountElements.get(0);
		System.out.println("grossFeeElement: "+grossFeeElement.getText());
		grossFee = new BigDecimal(amountElements.get(0).getText().toUpperCase().replaceAll("[-€,EUR\\s]+",""));
		return grossFee;
	}
	
	public String getPaymentStatus()
	{
		String paymentStatus;
		statusElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(statusLocator));
		WebElement statusElement = statusElements.get(0);
		paymentStatus = statusElement.getText().toUpperCase().trim().toLowerCase();
		return paymentStatus;
	}

}
