package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PayPalSandboxAgentPage extends PayPalSandboxPage
{
	
	//WebDriver webDriver;
	WebElement grossFeeElement;
	WebElement agentCommissionElement;
	WebElement instutionCommissionElement;
	WebElement summaryElement;
	
	By summaryLocator = By.cssSelector("a.transactionDescriptionContainer.js_transactionDescriptionContainer.linkedBlock.js_linkedBlock");
	By logoutLocator = By.cssSelector("ul.vx_globalNav-list_secondary > li:nth-of-type(3) > a");
	
	List<WebElement> summaryList;
	
	BigDecimal agentCommission;
	
	public PayPalSandboxAgentPage()
	{
		System.out.println("PayPalLiveAgentPage default constructor");
	}
	
	public PayPalSandboxAgentPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalSandBoxAgentPage constructor");
	}
	
	public BigDecimal getAgentCommission()
	{
		//summaryList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(summaryLocator));
		//summaryList.get(0).click();
		//feeLocator = By.cssSelector("div.row.purchaseDetailFields > div > dd:nth-of-type(3) > div > div:nth-of-type(2) > span");
		feeLocator = By.cssSelector("div.row.linkedBlock.js_linkedBlock:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) > span:nth-of-type(2)");
		agentCommissionElement = wait.until(ExpectedConditions.presenceOfElementLocated(feeLocator));
		String agentCommissionText = agentCommissionElement.getText().toUpperCase().replaceAll("[-€,.EUR\\s]+","");
		agentCommission = (new BigDecimal(agentCommissionText).divide(new BigDecimal("100"))).setScale(2,RoundingMode.HALF_UP);
		return agentCommission;
	}
	
	public String getPaymentStatus()
	{
		String paymentStatus;
		//statusElements = webDriver.findElements(By.cssSelector("div.wrapPaymentStatus"));
		//statusElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(statusLocator));
		//WebElement statusElement = statusElements.get(0);
		statusElement = wait.until(ExpectedConditions.presenceOfElementLocated(statusLocator));
		paymentStatus = statusElement.getText().toUpperCase().trim();
		return paymentStatus;
	}
	
	@Override
	public void logout()
	{
		System.out.println("'logout' running");
		logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(this.logoutLocator));
		logoutButton.click();
	}
	
}
