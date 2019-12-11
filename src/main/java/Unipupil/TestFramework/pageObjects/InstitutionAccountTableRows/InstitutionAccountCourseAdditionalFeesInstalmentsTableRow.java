package Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.math.BigDecimal;

public class InstitutionAccountCourseAdditionalFeesInstalmentsTableRow extends InstitutionAccountTableRow
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
	String orderID;
	
	InstalmentsPaymentTable instalmentsPaymentTable;
	AdditionalFeesTable additionalFeesTable;
	
	public InstitutionAccountCourseAdditionalFeesInstalmentsTableRow()
	{
		System.out.println("InstitutionAccountCourseAdditionalFeesInstalmentsTableRow default constructor");
	}
	
	public InstitutionAccountCourseAdditionalFeesInstalmentsTableRow(WebElement tableRow, String orderID)
	{
		//super(driver);
		//this.orderTableRow = orderTableRow;
		super(tableRow);
		this.orderID = orderID;
		System.out.println("InstitutionAccountCourseAdditionalFeesInstalmentsTableRow constructor");
		instalmentsPaymentTable = new InstalmentsPaymentTable(tableRow,orderID);
		additionalFeesTable = new AdditionalFeesTable(tableRow);
	}
	
	public void findElements()
	{
		super.findElements();
		instalmentsPaymentTable.findElements();
		additionalFeesTable.findElements();
	}
	
	public String getPaymentStatus()
	{
		return instalmentsPaymentTable.getPaymentStatus();
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
		return additionalFeesTable.additionalFeeTotal;
	}

	public BigDecimal displayedTotalCommissionPercent()
	{
		return totalCommissionPercent;
	}
	
	public String displayedStatus()
	{
		return instalmentsPaymentTable.getPaymentStatus();
	}
	
	public BigDecimal displayedInstalmentPercent(){
		return instalmentsPaymentTable.getInstalmentPercent();
	}

	public BigDecimal displayedInstalmentAmount()
	{
		return instalmentsPaymentTable.getInstalmentAmount();
	}
	
	public BigDecimal displayedInstalmentCommission()
	{
		return instalmentsPaymentTable.getInstalmentCommission();
	}
}
