package Unipupil.TestFramework.pageObjects.StudentAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.math.BigDecimal;

public class StudentAccountCourseAdditionalFeesInstalmentsTableRow extends StudentAccountTableRow
{
	//WebElement orderTableRow;
	
	WebElement coursePriceElement;
	WebElement additionalFeeNameElement;
	WebElement additionalFeeElement;
	WebElement additionalFeeTotalElement;
	WebElement paymentStatusElement;
	
	List<WebElement> instalmentScheduleTableRows;
	
	/*By instalmentScheduleTableRowsLocator = By.cssSelector("div#payment_schedule > table > tbody > tr");
	By instalmentOrderIDLocator = By.cssSelector("td:nth-of-type(1)");
	By instalmentPaymentStatusLocator = By.cssSelector("td:nth-of-type(2)");
	By instalmentNumberLocator = By.cssSelector("td:nth-of-type(3)");
	By instalmentPercentLocator = By.cssSelector("td:nth-of-type(4)");
	By instalmentDueDateLocator = By.cssSelector("td:nth-of-type(5)");
	By instalmentAmountLocator = By.cssSelector("td:nth-of-type(6)");
	By additionalFeeNameLocator = By.cssSelector("");
	By additionalFeeLocator = By.cssSelector("");
	By additionalFeeTotalLocator = By.cssSelector("");
	By coursePriceLocator = By.cssSelector("");*/
	
	String paymentStatus;
	
	String coursePriceText;
	String additionalFeeName;
	String additionalFee;
	String additionalFeeTotal;
	String orderID;
	
	InstalmentsPaymentTable instalmentsPaymentTable;
	AdditionalFeesTable additionalFeesTable;
	
	public StudentAccountCourseAdditionalFeesInstalmentsTableRow()
	{
		System.out.println("AgentAccountCourseInstalmentsTableRow default constructor");
	}
	
	public StudentAccountCourseAdditionalFeesInstalmentsTableRow(WebElement tableRow, String orderID)
	{
		//super(driver);
		//this.orderTableRow = orderTableRow;
		super(tableRow);
		this.orderID = orderID;
		System.out.println("AgentAccountCourseInstalmentsTableRow constructor");
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

}
