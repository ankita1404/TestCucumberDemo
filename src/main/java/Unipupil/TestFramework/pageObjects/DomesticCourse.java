package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Unipupil.TestFramework.utilities.ThreadSleep;;

public class DomesticCourse extends UnipupilWebPage
{
	
	//WebDriver driver;
	
	WebElement startDateField;
	WebElement finishDateField;
	WebElement coursePriceField;
	WebElement additionalFeeNameElement;
	WebElement additionalFeeElement;
	WebElement instalmentAmountInput;
	List<WebElement> instalmentTableRows;
	
	By startDateFieldLocator = By.cssSelector("input#edit-field-start-date-und-0-value-datepicker-popup-0");
	By finishDateFieldLocator = By.cssSelector("input#edit-field-finish-date-und-0-value-date");
	By coursePriceFieldLocator = By.cssSelector("input#edit-field-price-domestic-und-0-value");
	By additionalFeeNameElementLocator = By.cssSelector("input#edit-field-more-additional-cost-und-0-field-cost-type-und-0-value");
	By additionalFeeElementLocator = By.cssSelector("input#edit-field-more-additional-cost-und-0-field-more-price-und-0-value");
	By instalmentTableRowsLocator = By.cssSelector("table#field-instalment-values > tbody > tr");
	By instalmentNumberLocator = By.cssSelector("td:nth-of-type(2) > div:nth-of-type(1) > div > div > input");
	By instalmentPercentLocator = By.cssSelector("td:nth-of-type(2) > div:nth-of-type(2) > div > div > input");
	By instalmentDateLocator = By.cssSelector("td:nth-of-type(2) > div:nth-of-type(3) > div > div > input");
	
	String editPageUrl = "https://unipupil.com/en";
	String basicFeeString;
	String grossFeesString;
	String additionalFeeName;
	String additionalFeeString;
	String startDate;
	String finishDate;
	
	BigDecimal courseBasicFee;
	BigDecimal additionalFee;
	
	WebDriverWait wait;
	
	public DomesticCourse()
	{
		System.out.println("DomesticCourse default constructor");
	}
	
	public DomesticCourse(WebDriver driver)
	{
		super(driver);
		System.out.println("DomesticCourse constructor");
		wait = new WebDriverWait(driver,60);
	}
	
	public void getCourseFees()
	{
		startDateField = webDriver.findElement(startDateFieldLocator);
		//startDateField = wait.until(ExpectedConditions.presenceOfElementLocated(startDateFieldLocator));
		while(!(startDateField.isDisplayed())){
			System.out.println("Finding start date field");
		    ThreadSleep.sleep();
		}
		startDate = startDateField.getAttribute("value");
		finishDateField = webDriver.findElement(finishDateFieldLocator);
		//finishDateField = wait.until(ExpectedConditions.presenceOfElementLocated(finishDateFieldLocator));
		while(!(finishDateField.isDisplayed())){
			System.out.println("Finding finish date field");
		    ThreadSleep.sleep();
		}
		finishDate = finishDateField.getAttribute("value");
		coursePriceField = webDriver.findElement(coursePriceFieldLocator);
		basicFeeString = coursePriceField.getAttribute("value");
		courseBasicFee = new BigDecimal(basicFeeString);

	try{
		additionalFeeNameElement = webDriver.findElement(additionalFeeNameElementLocator);
		additionalFeeName = additionalFeeNameElement.getAttribute("value");
		additionalFeeElement = webDriver.findElement(additionalFeeElementLocator);
		additionalFee = new BigDecimal(additionalFeeElement.getAttribute("value"));
	} catch(Exception e){ }



	}

	
	
	public void findInstalmentInfoElements()
	{
		instalmentTableRows = webDriver.findElements(instalmentTableRowsLocator);
	}
	
	public String getStartDate()
	{
		return startDate;
	}
	
	public String getFinishDate()
	{
		return finishDate;
	}
	
	public BigDecimal getCourseBasicFee()
	{
		return courseBasicFee;
	}
	
	public BigDecimal getAdditionalFee()
	{
		return additionalFee;
	}
	
	public String getAdditionalFeeName()
	{
		return additionalFeeName;
	}
	
	public String getBasicFeeText()
	{
		return basicFeeString;
	}
	
	public String getEditPageUrl()
	{
		return this.editPageUrl;
	}
	

}
