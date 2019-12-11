package Unipupil.TestFramework.pageObjects.AgentAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import java.math.BigDecimal;

public class AgentAccountCourseInstalmentsTableRow extends AgentAccountTableRow
{
	String orderID;
	
	InstalmentsPaymentTable instalmentsPaymentTable;
	
	public AgentAccountCourseInstalmentsTableRow()
	{
		System.out.println("AgentAccountCourseInstalmentsTableRow default constructor");
	}
	
	public AgentAccountCourseInstalmentsTableRow(WebElement tableRow, String orderID)
	{
		super(tableRow);
		System.out.println("AgentAccountCourseInstalmentsTableRow constructor");
		this.orderID = orderID;
		instalmentsPaymentTable = new InstalmentsPaymentTable(tableRow,orderID);
	}
	
	public void findElements()
	{
		super.findElements();
		instalmentsPaymentTable.findElements();
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
