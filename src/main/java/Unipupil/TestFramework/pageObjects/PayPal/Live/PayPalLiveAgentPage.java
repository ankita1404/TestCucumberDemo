package Unipupil.TestFramework.pageObjects.PayPal.Live;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PayPalLiveAgentPage extends PayPalLivePage
{
	
	//WebDriver webDriver;
	WebElement grossFeeElement;
	WebElement agentCommissionElement;
	WebElement instutionCommissionElement;
	WebElement summaryElement;
	
	By summaryLocator = By.cssSelector("a.transactionDescriptionContainer.js_transactionDescriptionContainer.linkedBlock.js_linkedBlock");
	
	List<WebElement> summaryList;
	
	BigDecimal agentCommission;
	
	public PayPalLiveAgentPage()
	{
		System.out.println("PayPalLiveAgentPage default constructor");
	}
	
	public PayPalLiveAgentPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalSandBoxAgentPage constructor");
	}
	
	public BigDecimal getAgentCommission()
	{
		summaryList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(summaryLocator));
		summaryList.get(0).click();
		feeLocator = By.cssSelector("div.row.purchaseDetailFields > div > dd:nth-of-type(3) > div > div:nth-of-type(2) > span");
		agentCommissionElement = wait.until(ExpectedConditions.presenceOfElementLocated(feeLocator));
		agentCommission = new BigDecimal(agentCommissionElement.getText().toUpperCase().replaceAll("[-€,EUR\\s]+",""));
		return agentCommission;
	}
	
	public String getPaymentStatus()
	{
		String paymentStatus;
		//statusElements = webDriver.findElements(By.cssSelector("div.wrapPaymentStatus"));
		statusElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(statusLocator));
		WebElement statusElement = statusElements.get(0);
		paymentStatus = statusElement.getText().toUpperCase().trim();
		return paymentStatus;
	}
	
}
