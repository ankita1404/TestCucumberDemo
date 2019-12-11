package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CourseInstalmentSchedule extends UnipupilWebPage
{
	
	//WebDriver driver;
	WebElement instalmentNumberElement;
	Select instalmentPercentElement;
	WebElement instalmentDateElement;
	List<WebElement> instalmentTableRows;
	
	By instalmentTableRowsLocator = By.cssSelector("table#field-instalment-values > tbody > tr");
	By instalmentNumberLocator = By.cssSelector("input#edit-field-instalment-und-0-field-installment-number-und-0-value");
	By instalmentPercentLocator = By.cssSelector("select#edit-field-instalment-und-0-field-installment-amout-und");
	By instalmentDateLocator = By.cssSelector("input#edit-field-instalment-und-0-field-installment-date-und-0-value-datepicker-popup-0");
	
	BigDecimal firstInstalment;
	BigDecimal firstInstalmentPercent;
	
	public CourseInstalmentSchedule()
	{
		System.out.println("CourseInstalmentSchedule default constructor");
	}
	
	public CourseInstalmentSchedule(WebDriver driver)
	{
		super(driver);
		System.out.println("CourseInstalmentSchedule constructor");
	}
	
	public void findPageObjects(BigDecimal basicFee)
	{
		instalmentTableRows = webDriver.findElements(instalmentTableRowsLocator);
		Select firstInstalmentPercentElement = new Select(instalmentTableRows.get(0).findElement(instalmentPercentLocator));
		firstInstalmentPercent = new BigDecimal(firstInstalmentPercentElement.getFirstSelectedOption().getText());
		firstInstalment = ((basicFee.multiply(firstInstalmentPercent)).divide(new BigDecimal("100"))).setScale(2,RoundingMode.HALF_UP);
	}
	
	public BigDecimal getFirstInstalment()
	{
		
		return firstInstalment;
	}
	
}