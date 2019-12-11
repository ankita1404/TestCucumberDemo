package Unipupil.TestFramework.pageObjects.StudentAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.math.BigDecimal;

public class StudentAccountTableRow
{
	
	//WebDriver webDriver;
	WebElement orderTableRow;
	WebElement purchaseDateElement;
	WebElement courseTitleElement;
	WebElement startDateElement;
	WebElement finishDateElement;
	WebElement coursePriceElement;
	
	String purchaseDate;
	String courseTitle;
	String startDate;
	String finishDate;
	String coursePriceText;
	
	By purchaseDateLocator = By.cssSelector("td.views-field.views-field-created");
	By courseTitleLocator = By.cssSelector("td.views-field.views-field-php-1");
	By startDateLocator = By.cssSelector("td.views-field.views-field-php-5");
	By finishDateLocator = By.cssSelector("td.views-field.views-field-php-6");
	By coursePriceLocator = By.cssSelector("td.views-field.views-field-php-4");
	
	BigDecimal coursePrice;
	
	public StudentAccountTableRow()
	{
		System.out.println("InstitutionAccountTableRow default constructor");
	}
	
	public StudentAccountTableRow(WebElement tableRow)
	{
		System.out.println("InstitutionAccountTableRow constructor");
		//webDriver = driver;
		orderTableRow = tableRow;
	}
	
	public void findElements()
	{
		purchaseDateElement = orderTableRow.findElement(purchaseDateLocator);
		purchaseDate = purchaseDateElement.getText().trim();
		
		courseTitleElement = orderTableRow.findElement(courseTitleLocator);
		courseTitle = courseTitleElement.getText().trim();
		
		startDateElement = orderTableRow.findElement(startDateLocator);
		startDate = startDateElement.getText().trim();
		
		finishDateElement = orderTableRow.findElement(finishDateLocator);
		finishDate = finishDateElement.getText().trim();
		
		coursePriceElement = orderTableRow.findElement(coursePriceLocator);
		coursePriceText = coursePriceElement.getText().trim();
		coursePrice = new BigDecimal(coursePriceText.replaceAll("[a-zA-Z€\\s,]+", ""));
	}
	
	public String getPurchaseDate()
	{
		return purchaseDate;
	}
	
	public String getCourseTitle()
	{
		return courseTitle;
	}
	
	public String getStartDate()
	{
		return startDate;
	}
	
	public String getFinishDate()
	{
		return finishDate;
	}
	
	public BigDecimal getCoursePrice(){
		return coursePrice;
	}
	
}
