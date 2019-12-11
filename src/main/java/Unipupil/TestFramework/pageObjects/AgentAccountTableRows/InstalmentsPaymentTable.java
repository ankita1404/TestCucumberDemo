package Unipupil.TestFramework.pageObjects.AgentAccountTableRows;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Unipupil.TestFramework.pageObjects.*;

public class InstalmentsPaymentTable {
	
	List<WebElement> instalmentScheduleTableRows;
	WebElement instalmentOrderIDElement;
	WebElement instalmentPaymentStatusElement;
	WebElement instalmentNumberElement;
	WebElement instalmentPercentElement;
	WebElement instalmentDueDateElement;
	WebElement instalmentAmountElement;
	WebElement instalmentCommissionElement;
	
	By instalmentScheduleTableRowsLocator = By.cssSelector("div#payment_schedule > table > tbody > tr");
	By instalmentOrderIDLocator = By.cssSelector("td:nth-of-type(1)");
	By instalmentPaymentStatusLocator = By.cssSelector("td:nth-of-type(2)");
	By instalmentNumberLocator = By.cssSelector("td:nth-of-type(3)");
	By instalmentPercentLocator = By.cssSelector("td:nth-of-type(4)");
	By instalmentDueDateLocator = By.cssSelector("td:nth-of-type(5)");
	By instalmentAmountLocator = By.cssSelector("td:nth-of-type(6)");
	By instalmentCommissionLocator = By.cssSelector("td:nth-of-type(7)");
	
	WebElement tableRow;
	
	String orderID;
	String instalmentPaymentStatus;
	String instalmentNumber;
	String instalmentPercentText;
	String instalmentDueDateText;
	String instalmentAmountText;
	String instalmentCommissionText;
	
	BigDecimal instalmentPercent;
	BigDecimal instalmentAmount;
	BigDecimal instalmentCommission;
	
	public InstalmentsPaymentTable(){
	}

	public InstalmentsPaymentTable(WebElement tableRow, String orderID){
		this.tableRow = tableRow;
		this.orderID = orderID;
	}
	
	public void findElements()
	{
		System.out.println(this.getClass()+": " + "'findElements' running");
		System.out.println(InstalmentsPaymentTable.class);
		instalmentScheduleTableRows = tableRow.findElements(instalmentScheduleTableRowsLocator);
		for(WebElement instalmentScheduleTableRow : instalmentScheduleTableRows){
			instalmentOrderIDElement = instalmentScheduleTableRow.findElement(instalmentOrderIDLocator);
			if(instalmentOrderIDElement.getText().toUpperCase().equals(orderID)){
				instalmentPaymentStatusElement = instalmentScheduleTableRow.findElement(instalmentPaymentStatusLocator);
				instalmentPaymentStatus = instalmentPaymentStatusElement.getText().toUpperCase().trim();
				System.out.println(instalmentPaymentStatus);
				instalmentNumberElement = instalmentScheduleTableRow.findElement(instalmentNumberLocator);
				instalmentNumber = instalmentNumberElement.getText().toUpperCase().trim();
				System.out.println(instalmentNumber);
				instalmentPercentElement = instalmentScheduleTableRow.findElement(instalmentPercentLocator);
				instalmentPercentText = instalmentPercentElement.getText().toUpperCase().trim();
				instalmentPercent =  new BigDecimal(instalmentPercentText);
				System.out.println(instalmentPercent);
				instalmentDueDateElement = instalmentScheduleTableRow.findElement(instalmentDueDateLocator);
				instalmentDueDateText = instalmentDueDateElement.getText().toUpperCase().trim();
				System.out.println(instalmentDueDateText);
				instalmentAmountElement = instalmentScheduleTableRow.findElement(instalmentAmountLocator);
				instalmentAmountText = instalmentAmountElement.getText().toUpperCase().trim();
				instalmentAmount = new BigDecimal(instalmentAmountText.replaceAll("[€,]+", ""));
				System.out.println(instalmentAmount);
				instalmentCommissionElement = instalmentScheduleTableRow.findElement(instalmentCommissionLocator);
				instalmentCommissionText = instalmentCommissionElement.getText().toUpperCase().trim();
				instalmentCommission = new BigDecimal(instalmentCommissionText.replaceAll("[€,]+", ""));
				System.out.println(instalmentCommission);
				break;
			}
		}
		
	}
	
	public String getPaymentStatus(){
		return instalmentPaymentStatus;
	}
	
	public BigDecimal getInstalmentPercent(){
		return instalmentPercent;
	}
	
	public BigDecimal getInstalmentAmount(){
		return instalmentAmount;
	}
	
	public BigDecimal getInstalmentCommission(){
		return instalmentCommission;
	}
}
