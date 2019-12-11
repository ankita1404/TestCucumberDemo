package Unipupil.TestFramework.pageObjects.PayPal.Live;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayPalLiveEduInstNonAgentPage extends PayPalLivePage
{
	
	//WebDriver webDriver;
	WebElement grossFeeElement;
	WebElement agentCommissionElement;
	WebElement institutionCommissionElement;
	WebElement paymentStatusElement;
	
	BigDecimal grossFee;
	BigDecimal agentCommission;
	BigDecimal institutionCommission;
	
	public PayPalLiveEduInstNonAgentPage()
	{
		System.out.println("PayPalLiveEduInstPage default constructor");
	}
	
	public PayPalLiveEduInstNonAgentPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalLiveEduInstPage constructor");
	}
	
	public BigDecimal getGrossFee()
	{
		amountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(feeLocator));
		for(int i=0;i<amountElements.size();i++)
		{
			System.out.println(i + " " + amountElements.get(i).getText());
		}
		grossFeeElement = amountElements.get(1);
		grossFee = getAmount(grossFeeElement);
		return grossFee;
	}
	
	public BigDecimal getInstitutionCommission()
	{
		institutionCommissionElement = amountElements.get(0);
		institutionCommission = getAmount(institutionCommissionElement);
		return institutionCommission;
	}
	
	BigDecimal getAmount(WebElement element)
	{
		String elementText;
		BigDecimal amount;
		elementText = element.getText().toUpperCase().replaceAll("[-€,.EUR\\s]+","");
		amount = new BigDecimal(elementText).divide(new BigDecimal(100)).setScale(2,RoundingMode.HALF_UP);
		return amount;
	}
	
	public String getPaymentStatus()
	{
		String paymentStatus;
		statusElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(statusLocator));
		for(int i=0;i<statusElements.size();i++)
		{
			System.out.println(i + " " + statusElements.get(i).getText());
		}
		paymentStatusElement = statusElements.get(2);
		paymentStatus = paymentStatusElement.getText().toUpperCase().trim().toLowerCase();
		return paymentStatus;
		
	}
	

}
