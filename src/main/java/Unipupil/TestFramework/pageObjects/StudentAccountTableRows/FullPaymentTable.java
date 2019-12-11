package Unipupil.TestFramework.pageObjects.StudentAccountTableRows;

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
	
	By orderIDLocator = By.cssSelector("td:nth-of-type(2) > table > tbody > tr > td:nth-of-type(1) > a");
	By paymentStatusLocator = By.cssSelector("td:nth-of-type(2) > table > tbody > tr > td:nth-of-type(2)");
	
	List<WebElement> fullPaymentTableRows;
	WebElement orderIDElement;
	WebElement paymentStatusElement;
	WebElement tableRow;
	
	String orderID;
	String paymentStatus;
    
	FullPaymentTable(){
		
	}
	
	FullPaymentTable(WebElement tableRow,String orderID){
		this.tableRow = tableRow;
		this.orderID = orderID;
	}
	
	public void findElements(){
		orderIDElement = tableRow.findElement(orderIDLocator);
		paymentStatusElement = tableRow.findElement(paymentStatusLocator);
		paymentStatus = paymentStatusElement.getText();
	}
	
	public String getPaymentStatus(){
		return paymentStatus;
	}
}
