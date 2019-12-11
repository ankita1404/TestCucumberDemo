package Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Unipupil.TestFramework.pageObjects.*;
import Unipupil.TestFramework.pageObjects.StudentAccountTableRows.*;

public class FullPaymentTable {
	
	By orderIDLocator = By.cssSelector("td.views-field.views-field-php > table > tbody > tr > td:nth-of-type(1)");
	By paymentStatusLocator = By.cssSelector("td.views-field.views-field-php > table > tbody > tr > td:nth-of-type(2)");

	WebElement orderIDElement;
	WebElement paymentStatusElement;
	WebElement tableRow;
	
	String orderID;
	String paymentStatus;
    
	FullPaymentTable(){
		System.out.println("FullPaymentTable default constructor");
	}
	
	FullPaymentTable(WebElement tableRow,String orderID){
		System.out.println("FullPaymentTable constructor");
		this.tableRow = tableRow;
		this.orderID = orderID;
	}
	
	public void findElements(){
		paymentStatusElement = tableRow.findElement(paymentStatusLocator);
		paymentStatus = paymentStatusElement.getText().toUpperCase().trim().toLowerCase();
	}
	
	public String getPaymentStatus(){
		return paymentStatus;
	}
}
