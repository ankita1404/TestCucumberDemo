package Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.math.BigDecimal;

public class InstitutionAccountCourseInstalmentsTableRow extends InstitutionAccountTableRow
{
	//WebElement orderTableRow;
	
	WebElement coursePriceElement;
	WebElement additionalFeeNameElement;
	WebElement additionalFeeElement;
	WebElement additionalFeeTotalElement;
	WebElement paymentStatusElement;
	
	List<WebElement> instalmentScheduleTableRows;
	
	
	
	String paymentStatus;
	String coursePriceText;
	String additionalFeeName;
	String additionalFee;
	String additionalFeeTotal;
	
	public InstitutionAccountCourseInstalmentsTableRow()
	{
		System.out.println("AgentAccountCourseInstalmentsTableRow default constructor");
	}
	
	public InstitutionAccountCourseInstalmentsTableRow(WebElement tableRow)
	{
		//super(driver);
		//this.orderTableRow = orderTableRow;
		super(tableRow);
		System.out.println("AgentAccountCourseInstalmentsTableRow constructor");
	}
	
	public void findElements()
	{
		super.findElements();
		
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
