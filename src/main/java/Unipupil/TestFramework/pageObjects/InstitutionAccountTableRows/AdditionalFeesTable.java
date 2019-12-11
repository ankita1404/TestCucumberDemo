package Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows;

import java.math.BigDecimal;
import java.util.Iterator;
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
import Unipupil.TestFramework.pageObjects.AgentAccountTableRows.*;
import Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows.*;

public class AdditionalFeesTable {
	
	WebElement additionalFeeNameElement;
	WebElement additionalFeeElement;
	WebElement additionalFeeTotalElement;
	List<WebElement> addtionalFeesTableRows;
	
	By additionalFeeNameLocator = By.cssSelector("td.views-field.views-field-php-2 > table > tbody > tr:nth-of-type(2) > td:nth-of-type(1)");
	By additionalFeeLocator = By.cssSelector("td.views-field.views-field-php-2 > table > tbody > tr:nth-of-type(2) > td:nth-of-type(2)");
    By additionalFeeTotalLocator = By.cssSelector("td.views-field.views-field-php-3");
    By additionalFeesTableRowsLocator = By.cssSelector("td.views-field.views-field-php-2 > table > tbody > tr");
    
    String additionalFeeName;
    String additionalFeeText;
    String additionalFeeTotalText;
    
    BigDecimal additionalFee;
    BigDecimal additionalFeeTotal;
    
    WebElement tableRow;
	
	public AdditionalFeesTable(){
		
	}
	
	public AdditionalFeesTable(WebElement tableRow){
		this.tableRow = tableRow;
	}
	
	public void findElements()
	{
		additionalFeeNameElement = tableRow.findElement(additionalFeeNameLocator);
		additionalFeeName = additionalFeeNameElement.getText().toUpperCase().trim();
		
		additionalFeeElement = tableRow.findElement(additionalFeeLocator);
		additionalFeeText = additionalFeeElement.getText().toUpperCase().trim();
		System.out.println("***"+additionalFeeText+"***");
		additionalFee = new BigDecimal(additionalFeeText.replaceAll("[€,]+", ""));
		
		additionalFeeTotalElement = tableRow.findElement(additionalFeeTotalLocator);
		additionalFeeTotalText = additionalFeeTotalElement.getText().toUpperCase().trim();
		System.out.println("***"+additionalFeeTotalText+"***");
		additionalFeeTotal = new BigDecimal(additionalFeeTotalText.replaceAll("[€,]+", ""));
	}
	
	public String getAdditionalFeeName(){
		return additionalFeeName;
	}
	
	public BigDecimal getTotalAdditionalFee(){
		return additionalFeeTotal;
	}
	
	public BigDecimal getAdditionalFee(){
		return additionalFee;
	}
	
	public BigDecimal getAdditionalFeeTotal(){
		return additionalFeeTotal;
	}

}
