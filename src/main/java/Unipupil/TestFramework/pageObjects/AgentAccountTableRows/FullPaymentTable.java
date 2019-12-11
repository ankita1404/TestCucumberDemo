package Unipupil.TestFramework.pageObjects.AgentAccountTableRows;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Unipupil.TestFramework.pageObjects.StudentAccountTableRows.*;

public class FullPaymentTable {
	
	By orderIDLocator = By.cssSelector("td.views-field.views-field-php-4 > table > tbody > tr > td:nth-of-type(1)");
	By paymentStatusLocator = By.cssSelector("td.views-field.views-field-php-4 > table > tbody > tr > td:nth-of-type(2)");
	By commissionLocator = By.cssSelector("td.views-field.views-field-php-4 > table > tbody > tr > td:nth-of-type(3)");

	WebElement orderIDElement;
	WebElement paymentStatusElement;
	WebElement commissionElement;
	WebElement tableRow;
	
	String paymentStatus;
	
	BigDecimal commission;
    
	FullPaymentTable(){
		System.out.println("FullPaymentTable default constructor");
	}
	
	FullPaymentTable(WebElement tableRow,String orderID){
		System.out.println("FullPaymentTable constructor");
		this.tableRow = tableRow;
	}
	
	public void findElements(){
		paymentStatusElement = tableRow.findElement(paymentStatusLocator);
		paymentStatus = paymentStatusElement.getText().toUpperCase().trim().toLowerCase();
		commissionElement = tableRow.findElement(commissionLocator);
		commission = new BigDecimal(commissionElement.getText().toUpperCase().replaceAll("[€,]+", "").trim());}
	
	
	public String getPaymentStatus(){
		return paymentStatus;
	}
	
	public BigDecimal getCommission(){
		return commission;
	}

}
