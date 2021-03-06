package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CourseClassWorkshopMoreInfoPageInternational extends UnipupilWebPage
{
	//WebDriver driver;
	WebElement coursePriceElement;
	WebElement additionalFeesCheckbox;
	WebElement additionalFeesLabel;
	WebElement grossFeesElement;
	WebElement fullPaymentLabelElement;
	WebElement addToCartButton;
	
	By coursePriceElementLocator = By.cssSelector("span.price-class.only_internation_pro");
	By additionalFeesCheckboxLocator = By.cssSelector("#edit-attributes-14--2 > div > input[type='checkbox']");
	By additionalFeesLabelLocator = By.cssSelector("#edit-attributes-14--2 > div > label");
	By grossFeesElementLocator = By.cssSelector("div.class-prod > div > ul > li:nth-child(3) div.content > div:nth-of-type(6) > span");
	By fullPaymentLabelLocator = By.cssSelector("div.add-to-cart > form > div > div > div:nth-of-type(2) > div > div > div > label");
	By addToCartButtonLocator = By.cssSelector("div#edit-actions--3 > input");

	String grossFeesTextWithComma;
	String addFeesLabelText;
	String grossFeesText;
	
	BigDecimal displayedCourseBasicFee;
	BigDecimal courseBasicFee;
	BigDecimal additionalFee;
	BigDecimal grossFees;
	
	String basicFeeString;
	String grossFeesString;
	String additionalFeeName;
	String additionalFeeString;
	String startDate;
	String finishDate;
	String courseBasicFeeText;
	
	
	public CourseClassWorkshopMoreInfoPageInternational()
	{
		System.out.println("CourseClassWorkshopMoreInfoPageDomestic default constructor");
	}
	
	public CourseClassWorkshopMoreInfoPageInternational(WebDriver driver)
	{
		super(driver);
		System.out.println("CourseClassWorkshopMoreInfoPageInternational constructor");
		//super.driver = driver;
	}
	
	public BigDecimal getDisplayedBasicCourseFee()
	{
		coursePriceElement = webDriver.findElement(coursePriceElementLocator);
		courseBasicFeeText = coursePriceElement.getText();
		//displayedCourseBasicFee = new BigDecimal(courseBasicFeeText.split("[€$£]")[1].replaceAll("[.]+",""));
		displayedCourseBasicFee = new BigDecimal(courseBasicFeeText.split("[€$£]")[1].split ("[f]")[0].replaceAll("[,]+",""));
		return displayedCourseBasicFee;

	}
	
	public String getAddtionalFeesLabel()
	{
		additionalFeesCheckbox = webDriver.findElement(additionalFeesCheckboxLocator);
		additionalFeesLabel = webDriver.findElement(additionalFeesLabelLocator);
		addFeesLabelText = additionalFeesLabel.getText().toUpperCase().trim();
		return addFeesLabelText;
	}
	
	public BigDecimal calcGrossFees()
	{
		additionalFee = new BigDecimal(addFeesLabelText.split("[€$£]")[1].replaceAll("[,]+",""));
		// check additional fees checkbox
		additionalFeesCheckbox.click();

		try
		{
			Thread.sleep(20000);  // prevent abrupt termination of javascript execution
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}

		grossFeesElement = webDriver.findElement(grossFeesElementLocator);
		grossFeesText = grossFeesElement.getText().toUpperCase().replaceAll("[€$£,a-zA-Z\\s]+", "");
		grossFees = new BigDecimal(grossFeesText);

		return grossFees;
	}
	
	public BigDecimal getGrossFees()
	{
		return grossFees;
	}
	
	public String getAdditionalFeeName()
	{
		return additionalFeeName;
	}
	
	public BigDecimal getAdditionalFee()
	{
		return additionalFee;
	}
	
	/*public String getBasicFeeText()
	{
		fullPaymentLabelElement = webDriver.findElement(fullPaymentLabelLocator);
		courseBasicFeeText = fullPaymentLabelElement.getText();
		String tokens[] = courseBasicFeeText.split("\\s");
		courseBasicFeeText = tokens[tokens.length-1].trim();
		return courseBasicFeeText;
	}*/
	
	public String getAddFeesLabelText()
	{
		return addFeesLabelText;
	}
	
	public void addToCart()
	{
		addToCartButton = webDriver.findElement(addToCartButtonLocator); 
        addToCartButton.click();

	}
	
	public String getGrossFeesText()
	{
		return grossFeesText;
	}


}

