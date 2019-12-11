package Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.math.BigDecimal;

public class InstitutionAccountTableRow
{
	
	//WebDriver webDriver;
	WebElement orderTableRow;
	WebElement purchaseDateElement;
	WebElement courseTitleElement;
	WebElement startDateElement;
	WebElement finishDateElement;
	WebElement coursePriceElement;
	WebElement startAndEndDateElement;
	WebElement additionalPriceElement;
	WebElement agentCommissionPercentElement;
	WebElement institutionCommissionPercentElement;
	WebElement totalCommissionPercentElement;
	WebElement totalCommissionPaidElement;
	
	String purchaseDate;
	String courseTitle;
	String startDate;
	String finishDate;
	String coursePriceText;
	String additionalPriceText;
	String agentCommissionPercentText;
	String institutionCommissionPercentText;
	String totalCommissionPercentText;
	String totalCommissionPaidText;
	
	By purchaseDateLocator = By.cssSelector("td.views-field.views-field-created-1");
	By courseTitleLocator = By.cssSelector("td.views-field.views-field-php");
	By startAndEndDatesLocator = By.cssSelector("td.views-field.views-field-php-12");
	By coursePriceLocator = By.cssSelector("td.views-field.views-field-php-11");
	By additionalPriceLocator = By.cssSelector("td.views-field.views-field-php-3");
	By totalCommissionPercentLocator = By.cssSelector("td.views-field.views-field-php-5");
	By institutionCommissionPercentLocator = By.cssSelector("td.views-field.views-field-php-6 > table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	By agentCommissionPercentLocator = By.cssSelector("td.views-field.views-field-php-6 > table > tbody > tr:nth-of-type(2) > td:nth-of-type(2)");
	By totalCommissionPaidLocator = By.cssSelector("td.views-field.views-field-php-7");
	
	BigDecimal coursePrice;
	BigDecimal agentCommissionPercent;
	BigDecimal institutionCommissionPercent;
	BigDecimal totalCommissionPercent;
	BigDecimal totalCommissionPaid;
	BigDecimal additionalPrice;
	
	public InstitutionAccountTableRow()
	{
		System.out.println("InstitutionAccountTableRow default constructor");
	}
	
	public InstitutionAccountTableRow(WebElement tableRow)
	{
		System.out.println("InstitutionAccountTableRow constructor");
		//webDriver = driver;
		orderTableRow = tableRow;
	}
	
	public void findElements()
	{
		purchaseDateElement = orderTableRow.findElement(purchaseDateLocator);
		purchaseDate = purchaseDateElement.getText().toUpperCase().trim();
		
		courseTitleElement = orderTableRow.findElement(courseTitleLocator);
		courseTitle = courseTitleElement.getText().toUpperCase().trim();
		
		startAndEndDateElement = orderTableRow.findElement(startAndEndDatesLocator);
		startDate = startAndEndDateElement.getText().toUpperCase().split("\n")[0].trim();
		finishDate = startAndEndDateElement.getText().toUpperCase().split("\n")[1].trim();
		
		coursePriceElement = orderTableRow.findElement(coursePriceLocator);
		coursePriceText = coursePriceElement.getText().toUpperCase().trim();
		System.out.println("***"+coursePriceText+"***");
		coursePrice = new BigDecimal(coursePriceText.replaceAll("[€,]+", ""));
		
		additionalPriceElement = orderTableRow.findElement(additionalPriceLocator);
		additionalPriceText = additionalPriceElement.getText().toUpperCase().trim();
		System.out.println("***"+additionalPriceText+"***");
		additionalPrice = new BigDecimal(additionalPriceText.replaceAll("[€,]+",""));
		
		agentCommissionPercentElement = orderTableRow.findElement(agentCommissionPercentLocator);
		agentCommissionPercentText = agentCommissionPercentElement.getText().toUpperCase().trim();
		String[] tokens = agentCommissionPercentText.split("%");
		System.out.println("tokens.length: "+tokens.length);
		if(tokens.length == 0)
		{
			agentCommissionPercent = new BigDecimal("0");
		}
		else{
		    agentCommissionPercent = new BigDecimal(tokens[0].trim());
		}
		
		institutionCommissionPercentElement = orderTableRow.findElement(institutionCommissionPercentLocator);
		institutionCommissionPercentText = institutionCommissionPercentElement.getText().toUpperCase().trim();
		institutionCommissionPercent = new BigDecimal(institutionCommissionPercentText.split("%")[0].trim());
		
		totalCommissionPercentElement = orderTableRow.findElement(totalCommissionPercentLocator);
		totalCommissionPercentText = totalCommissionPercentElement.getText().toUpperCase().trim();
		totalCommissionPercent = new BigDecimal(totalCommissionPercentText.split("%")[0].trim());
		
		totalCommissionPaidElement = orderTableRow.findElement(totalCommissionPaidLocator);
		totalCommissionPaidText = totalCommissionPaidElement.getText().toUpperCase().trim();
		totalCommissionPaid = new BigDecimal(totalCommissionPaidText.trim().replaceAll("[€,]+",""));
	}
	
	public String getPurchaseDate()
	{
		return purchaseDate;
	}
	
	public String getCourseTitle()
	{
		return courseTitle;
	}
	
	public String getStartDate()
	{
		return startDate;
	}
	
	public String getFinishDate()
	{
		return finishDate;
	}
	
	public BigDecimal getCoursePrice(){
		return coursePrice;
	}
	
	public BigDecimal getTotalCommissionPaid()
	{
		return totalCommissionPaid;
	}
	
	public BigDecimal getAgentCommissionPercent()
	{
		return agentCommissionPercent;
	}
	
	
	public BigDecimal getInstitutionCommissionPercent()
	{
		return institutionCommissionPercent;
	}
	
	public BigDecimal getTotalCommissionPercent()
	{
		return totalCommissionPercent;
	}
	
}
