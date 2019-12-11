package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InternationalCourse extends UnipupilWebPage
{
	
	//WebDriver driver;
	
	WebElement startDateField;
	WebElement finishDateField;
	WebElement coursePriceField;
	WebElement additionalFeeNameElement;
	WebElement additionalFeeElement;
	
	By startDateFieldLocator = By.cssSelector("input#edit-field-start-date-und-0-value-datepicker-popup-0");
	By finishDateFieldLocator = By.cssSelector("input#edit-field-finish-date-und-0-value-date");
	By coursePriceFieldLocator = By.cssSelector("input#edit-field-price-international-und-0-value");
	By additionalFeeNameElementLocator = By.cssSelector("input#edit-field-more-int-additional-cost-und-0-field-int-cost-type-und-0-value");
	By additionalFeeElementLocator = By.cssSelector("input#edit-field-more-int-additional-cost-und-0-field-int-more-price-und-0-value");
	
	String editPageUrl = "https://unipupil.com/en/en/node/102042384/edit?inst=101468770";
	String basicFeeString;
	String grossFeesString;
	String additionalFeeName;
	String additionalFeeString;
	String startDate;
	String finishDate;
	
	BigDecimal courseBasicFee;
	BigDecimal additionalFee;
	
	public InternationalCourse()
	{
		System.out.println("InternationalCourse default cosntructor");
	}
	
	public InternationalCourse(WebDriver driver)
	{
		super(driver);
		System.out.println("InternationalCourse constructor");
	}
	
	public void getCourseFees()
	{
		startDateField = webDriver.findElement(startDateFieldLocator);
		startDate = startDateField.getAttribute("value");
		finishDateField = webDriver.findElement(finishDateFieldLocator);
		finishDate = finishDateField.getAttribute("value");
		coursePriceField = webDriver.findElement(coursePriceFieldLocator);
		basicFeeString = coursePriceField.getAttribute("value");

		courseBasicFee = new BigDecimal(basicFeeString);
		additionalFeeNameElement = webDriver.findElement(additionalFeeNameElementLocator);
		additionalFeeName = additionalFeeNameElement.getAttribute("value");
		additionalFeeElement = webDriver.findElement(additionalFeeElementLocator);
		additionalFee = new BigDecimal(additionalFeeElement.getAttribute("value"));
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
