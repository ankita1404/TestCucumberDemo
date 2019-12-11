package Unipupil.TestFramework.pageObjects.PayPal.Live;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PayPalLiveUnipupilPage extends PayPalLivePage
{
	
	//WebDriver webDriver;
	WebElement grossFeeElement;
	WebElement agentCommissionElement;
	WebElement institutionCommissionElement;
	
	BigDecimal institutionCommission;
	
	public PayPalLiveUnipupilPage()
	{
		System.out.println("PayPalSandboxUnipupilPage default constructor");
	}
	
	public PayPalLiveUnipupilPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PayPalSandboxUnipupilPage constructor");
	}
	
	public BigDecimal getInstitutionCommission()
	{
		//amountElements = webDriver.findElements(By.cssSelector("td[class='cur_val']"));
		amountElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(feeLocator));
		institutionCommissionElement = amountElements.get(0);
		System.out.println("institutionCommissionElement: "+institutionCommissionElement.getText());
		institutionCommission = new BigDecimal(institutionCommissionElement.getText().toUpperCase().replaceAll("[-€,EUR\\s]+",""));
		return institutionCommission;
	}
	
}
