package Unipupil.TestFramework.pageObjects.PayPal.Sandbox;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayPalSandboxUnipupilPage extends PayPalSandboxPage
{
	
	//WebDriver webDriver;
	WebElement grossFeeElement;
	WebElement agentCommissionElement;
	WebElement institutionCommissionElement;
	
	BigDecimal institutionCommission;
	
	public PayPalSandboxUnipupilPage()
	{
		System.out.println("PayPalSandboxUnipupilPage default constructor");
	}
	
	public PayPalSandboxUnipupilPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalSandboxUnipupilPage constructor");
	}
	
	public BigDecimal getInstitutionCommission()
	{
		//amountElements = webDriver.findElements(By.cssSelector("td[class='cur_val']"));
		//amountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(feeLocator));
		//institutionCommissionElement = amountElements.get(0);
		institutionCommissionElement = wait.until(ExpectedConditions.presenceOfElementLocated(feeLocator));
		System.out.println("institutionCommissionElement: "+institutionCommissionElement.getText());
		String institutionCommissionText = institutionCommissionElement.getText().toUpperCase().replaceAll("[-€,.EUR\\s]+","");
		institutionCommission = (new BigDecimal(institutionCommissionText).divide(new BigDecimal("100"))).setScale(2,RoundingMode.HALF_UP);
		return institutionCommission;
	}
	
}
