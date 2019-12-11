package Unipupil.TestFramework.pageObjects.AgentAccountTableRows;

//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.math.BigDecimal;

public class AgentAccountCourseFullPaymentTableRow extends AgentAccountTableRow
{
	WebElement orderIDElement;
	WebElement paymentStatusElement;
	
	String paymentStatus;
	String orderID;
	
	FullPaymentTable fullPaymentTable;
	
	public AgentAccountCourseFullPaymentTableRow()
	{
		System.out.println("AgentAccountCourseInstalmentsTableRow default constructor");
	}
	
	public AgentAccountCourseFullPaymentTableRow(WebElement tableRow, String orderID)
	{
		super(tableRow);
		System.out.println("AgentAccountCourseInstalmentsTableRow constructor");
		this.orderID = orderID;
		fullPaymentTable = new FullPaymentTable(tableRow,orderID);
	}
	
	public void findElements()
	{
		super.findElements();
		fullPaymentTable.findElements();
	}
	
	public String getPaymentStatus()
	{
		return fullPaymentTable.getPaymentStatus();
	}
	
	public BigDecimal getCommission()
	{
		return fullPaymentTable.getCommission();
	}

}
