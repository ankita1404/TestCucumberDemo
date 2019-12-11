package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayPalSandboxEduInstNonAgentPage extends PayPalSandboxPage
{
	
	//WebDriver webDriver;
	WebElement grossFeeTransactionElement;
	WebElement grossFeeElement;
	WebElement institutionCommissionElement;
	WebElement paymentStatusElement;
	
	BigDecimal grossFee;
	BigDecimal institutionCommission;
	
	By grossFeeTransactionLocator = By.cssSelector("ul.transactionList.js_transactionList > li:nth-of-type(2)");
	By grossFeeLocator = By.cssSelector("ul.transactionList.js_transactionList > li:nth-of-type(3) >"
			           + " div:nth-of-type(2) > div > div:nth-of-type(2) div:nth-of-type(2) > div > dl >"
			           + " div > dd:nth-of-type(1) > div > div:nth-of-type(2) > span");
	//By grossFeeLocator = By.cssSelector("div.purchaseDetailfields:nth-of-type(1) > dd:nth-of-type(1) > div.row > div:nth-of-type(2) > span");
	By institutionCommissionLocator = By.cssSelector("ul.transactionList.js_transactionList > li:nth-of-type(1) > div >"
			                        + " div > div:nth-of-type(2) > div > span:nth-of-type(3)");
	By statusElementLocator = By.cssSelector("div > div > div:nth-of-type(2) > div:nth-of-type(1) > span:nth-of-type(2)");
	By logoutLocator = By.cssSelector("ul.vx_globalNav-list_secondary > li:nth-of-type(3) > a");	
	
	public PayPalSandboxEduInstNonAgentPage()
	{
		System.out.println("PayPalLiveEduInstPage default constructor");
	}
	
	public PayPalSandboxEduInstNonAgentPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalLiveEduInstPage constructor");
	}
	
	public String getPaymentStatus()
	{
		String paymentStatus;
		grossFeeTransactionElement = wait.until(ExpectedConditions.presenceOfElementLocated(grossFeeTransactionLocator));
		paymentStatusElement = grossFeeTransactionElement.findElement(statusElementLocator);
		/*for(int i=0;i<statusElements.size();i++)
		{
			System.out.println(i + " " + statusElements.get(i).getText());
		}*/
		//paymentStatusElement = statusElements.get(2);
		paymentStatusElement = grossFeeTransactionElement.findElement(statusElementLocator);
		paymentStatus = paymentStatusElement.getText().toUpperCase().trim().toLowerCase();
		return paymentStatus;
		
	}
	
	public BigDecimal getGrossFee()
	{
		/*amountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(feeLocator));
		for(int i=0;i<amountElements.size();i++)
		{
			System.out.println(i + " " + amountElements.get(i).getText());
		}
		grossFeeElement = amountElements.get(1);*/
		grossFeeElement = wait.until(ExpectedConditions.presenceOfElementLocated(feeLocator));
		grossFee = getAmount(grossFeeElement);
		return grossFee;
	}
	
	public BigDecimal getInstitutionCommission()
	{
		//institutionCommissionElement = amountElements.get(1);
		institutionCommissionElement = wait.until(ExpectedConditions.presenceOfElementLocated(institutionCommissionLocator));
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
	
	@Override
	public void logout()
	{
		System.out.println("'logout' running");
		logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(this.logoutLocator));
		logoutButton.click();
	}	

}
