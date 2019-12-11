package Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import java.math.BigDecimal;
//import Unipupil.TestFramework.pageObjects.StudentAccountTableRows.*;

public class InstitutionAccountCourseFullPaymentAdditionalFeesTableRow extends InstitutionAccountTableRow
{
	
	String paymentStatus;
	String coursePriceText;
	String additionalFeeName;
	String additionalFee;
	String additionalFeeTotal;
	
	WebElement tableRow;
	
	String orderNumber;
	
	AdditionalFeesTable additionalFeesTable;
	FullPaymentTable fullPaymentTable;
	
	public InstitutionAccountCourseFullPaymentAdditionalFeesTableRow()
	{
		System.out.println("AgentAccountFullPaymentCourseAdditionalFeesTableRow default constructor");
	}
	
	public InstitutionAccountCourseFullPaymentAdditionalFeesTableRow(WebElement tableRow, String orderNumber)
	{
		super(tableRow);
		System.out.println("AgentAccountFullPaymentCourseAdditionalFeesTableRow constructor");
		this.tableRow = tableRow;
		this.orderNumber = orderNumber;
		additionalFeesTable = new AdditionalFeesTable(tableRow);
		fullPaymentTable = new FullPaymentTable(tableRow,orderNumber);
		
	}
	
	public void findElements()
	{
		super.findElements();
		additionalFeesTable.findElements();
		fullPaymentTable.findElements();
	}
	
	public String getPaymentStatus()
	{
		return fullPaymentTable.getPaymentStatus(); //paymentStatus;
	}
	
	
	public String getAdditionalFeeName()
	{
		return additionalFeesTable.getAdditionalFeeName();
	}
	
	public BigDecimal getAdditionalFee()
	{
		return additionalFeesTable.getAdditionalFee();
	}
	
	public BigDecimal getAdditionalFeeTotal()
	{
		return additionalFeesTable.getAdditionalFeeTotal();
	}
	
	

}
