package Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.math.BigDecimal;

public class InstitutionAccountCourseFullPaymentTableRow extends InstitutionAccountTableRow
{
	//WebElement orderTableRow;
	
	WebElement coursePriceElement;
	WebElement additionalFeeNameElement;
	WebElement additionalFeeElement;
	WebElement additionalFeeTotalElement;
	WebElement paymentStatusElement;
	
	List<WebElement> instalmentScheduleTableRows;
	
	By instalmentScheduleTableRowsLocator = By.cssSelector("div#payment_schedule > table > tbody > tr");
	By instalmentOrderIDLocator = By.cssSelector("td:nth-of-type(1)");
	By instalmentPaymentStatusLocator = By.cssSelector("td:nth-of-type(2)");
	By instalmentNumberLocator = By.cssSelector("td:nth-of-type(3)");
	By instalmentPercentLocator = By.cssSelector("td:nth-of-type(4)");
	By instalmentDueDateLocator = By.cssSelector("td:nth-of-type(5)");
	By instalmentAmountLocator = By.cssSelector("td:nth-of-type(6)");
	By additionalFeeNameLocator = By.cssSelector("");
	By additionalFeeLocator = By.cssSelector("");
	By additionalFeeTotalLocator = By.cssSelector("");
	By coursePriceLocator = By.cssSelector("");
	
	String paymentStatus;
	String coursePriceText;
	String additionalFeeName;
	String additionalFee;
	String additionalFeeTotal;
	
	public InstitutionAccountCourseFullPaymentTableRow()
	{
		System.out.println("AgentAccountCourseInstalmentsTableRow default constructor");
	}
	
	public InstitutionAccountCourseFullPaymentTableRow(WebElement tableRow)
	{
		//super(driver);
		//this.orderTableRow = orderTableRow;
		super(tableRow);
		System.out.println("AgentAccountCourseInstalmentsTableRow constructor");
	}
	
	public void findElements()
	{
		super.findElements();
		paymentStatusElement = orderTableRow.findElement(instalmentPaymentStatusLocator);
		paymentStatus = paymentStatusElement.getText().toUpperCase().trim().toLowerCase();
		
		coursePriceElement = orderTableRow.findElement(coursePriceLocator);
		coursePriceText = coursePriceElement.getText().toUpperCase().trim();
		
		additionalFeeNameElement = orderTableRow.findElement(additionalFeeNameLocator);
		additionalFeeName = additionalFeeNameElement.getText().toUpperCase().trim();
		
		additionalFeeElement = orderTableRow.findElement(additionalFeeLocator);
		additionalFee = additionalFeeElement.getText().toUpperCase().trim();
		
		additionalFeeTotalElement = orderTableRow.findElement(additionalFeeTotalLocator);
		additionalFeeTotal = additionalFeeTotalElement.getText().toUpperCase().trim();
	}
	
	public String getPaymentStatus()
	{
		return paymentStatus;
	}
	
	public BigDecimal getCoursePrice()
	{
		return new BigDecimal(coursePriceText.replaceAll("[€,]+",""));
	}
	
	public String getAdditionalFeeName()
	{
		return additionalFeeName;
	}
	
	public String getAdditionalFee()
	{
		return additionalFee;
	}
	
	public String getAdditionalFeeTotal()
	{
		return additionalFeeTotal;
	}
	
	

}
