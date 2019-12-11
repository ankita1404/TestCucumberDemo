package Unipupil.TestFramework.pageObjects.StudentAccountTableRows;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Unipupil.TestFramework.pageObjects.*;
import Unipupil.TestFramework.pageObjects.StudentAccountTableRows.*;

public class InstalmentsPaymentTable {
	
	List<WebElement> instalmentScheduleTableRows;
	WebElement instalmentOrderIDElement;
	WebElement instalmentPaymentStatusElement;
	WebElement instalmentNumberElement;
	WebElement instalmentPercentElement;
	WebElement instalmentDueDateElement;
	WebElement instalmentAmountElement;
	
	By instalmentScheduleTableRowsLocator = By.cssSelector("div#payment_schedule > table > tbody > tr");
	By instalmentOrderIDLocator = By.cssSelector("td:nth-of-type(1)");
	By instalmentPaymentStatusLocator = By.cssSelector("td:nth-of-type(2)");
	By instalmentNumberLocator = By.cssSelector("td:nth-of-type(3)");
	By instalmentPercentLocator = By.cssSelector("td:nth-of-type(4)");
	By instalmentDueDateLocator = By.cssSelector("td:nth-of-type(5)");
	By instalmentAmountLocator = By.cssSelector("td:nth-of-type(6)");
	
	WebElement tableRow;
	
	String orderID;
	String instalmentPaymentStatus;
	String instalmentNumber;
	String instalmentPercentText;
	String instalmentDueDateText;
	String instalmentAmountText;
	
	BigDecimal instalmentPercent;
	BigDecimal instalmentAmount;
	
	public InstalmentsPaymentTable(){
	}

	public InstalmentsPaymentTable(WebElement tableRow, String orderID){
		this.tableRow = tableRow;
		this.orderID = orderID;
	}
	
	public void findElements()
	{
		instalmentScheduleTableRows = tableRow.findElements(instalmentScheduleTableRowsLocator);
		for(WebElement instalmentScheduleTableRow : instalmentScheduleTableRows){
			instalmentOrderIDElement = instalmentScheduleTableRow.findElement(instalmentOrderIDLocator);
			if(instalmentOrderIDElement.getText().equals(orderID)){
				instalmentPaymentStatusElement = instalmentScheduleTableRow.findElement(instalmentPaymentStatusLocator);
				instalmentPaymentStatus = instalmentPaymentStatusElement.getText().trim();
				instalmentNumberElement = instalmentScheduleTableRow.findElement(instalmentNumberLocator);
				instalmentNumber = instalmentNumberElement.getText().trim();
				instalmentPercentElement = instalmentScheduleTableRow.findElement(instalmentPercentLocator);
				instalmentPercentText = instalmentPercentElement.getText().trim();
				instalmentPercent =  new BigDecimal(instalmentPercentText);
				instalmentDueDateElement = instalmentScheduleTableRow.findElement(instalmentDueDateLocator);
				instalmentDueDateText = instalmentDueDateElement.getText().trim();
				instalmentAmountElement = instalmentScheduleTableRow.findElement(instalmentAmountLocator);
				instalmentAmountText = instalmentAmountElement.getText().trim();
				instalmentAmount = new BigDecimal(instalmentAmountText.replaceAll("[€,]+", ""));
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
}
