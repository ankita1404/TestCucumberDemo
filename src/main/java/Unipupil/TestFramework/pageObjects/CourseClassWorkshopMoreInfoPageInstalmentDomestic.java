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

public class CourseClassWorkshopMoreInfoPageInstalmentDomestic extends UnipupilWebPage
{
	//WebDriver driver;
	
	WebElement grossFeesElement;
	WebElement coursePriceElement;
	WebElement fullPaymentLabelElement;
	WebElement additionalFeesCheckbox;
	WebElement additionalFeesLabel;
	WebElement instalmentRadioButton;
	
	WebElement addToCartButton;
	
	By coursePriceElementLocator = By.cssSelector("span.price-class.only_dome_pro");
	By grossFeesElementLocator = By.cssSelector("div.content > div:nth-of-type(6) > span");
	By addToCartButtonLocator = By.cssSelector("div#edit-actions--2 > input");
	By fullPaymentLabelLocator = 
			By.cssSelector("div.form-radios > div:nth-of-type(1) > label");
	By fullPaymentRadioLocator = 
			By.cssSelector("div.form-radios > div:nth-of-type(1) > input");
	By instalmentPaymentRadioLabelLocator = 
			By.cssSelector("div.form-radios > div:nth-of-type(2) > label");
	By instalmentRadioLocator = 
			By.cssSelector("div.form-radios > div:nth-of-type(2) > input");
	
	
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
	
	
	
	public CourseClassWorkshopMoreInfoPageInstalmentDomestic()
	{
		System.out.println("CourseClassWorkshopMoreInfoPageInstalmentDomestic default constructor");
	}
	
	public CourseClassWorkshopMoreInfoPageInstalmentDomestic(WebDriver driver)
	{
		super(driver);
		System.out.println("CourseClassWorkshopMoreInfoCartPage constructor");
		//super.driver = driver;
	}
	
	public BigDecimal getDisplayedBasicCourseFee()
	{
		coursePriceElement = webDriver.findElement(coursePriceElementLocator);
		courseBasicFeeText = coursePriceElement.getText();
		System.out.println(courseBasicFeeText);
		displayedCourseBasicFee = new BigDecimal(courseBasicFeeText.split("€")[1]);
		return displayedCourseBasicFee;
	}
	
	public String getAddtionalFeesLabel()
	{
		additionalFeesCheckbox = webDriver.findElement(By.cssSelector("div.form-checkboxes > div:nth-of-type(1) > input"));
		additionalFeesLabel = webDriver.findElement(By.cssSelector("label[class='option']"));
		addFeesLabelText = additionalFeesLabel.getText().toUpperCase().trim();
		return addFeesLabelText;
	}
	
	public void calcGrossFeesAdditionalItems()
	{
		additionalFee = new BigDecimal(addFeesLabelText.split("[€£$]")[1].replaceAll("[,]+",""));
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
		grossFeesText = grossFeesElement.getText();
		grossFees = new BigDecimal(grossFeesText.replaceAll("[€$£,a-zA-Z\\s]+", ""));
	}
	
	public void calcGrossFeesAdditionalItemsInstalment()
	{
		additionalFee = new BigDecimal(addFeesLabelText.split("[€£$]")[1].replaceAll("[,]+",""));
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
		instalmentRadioButton = webDriver.findElement(instalmentRadioLocator);
		instalmentRadioButton.click();
		try
		{
			Thread.sleep(20000);  // prevent abrupt termination of javascript execution
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		grossFeesElement = webDriver.findElement(grossFeesElementLocator);
		grossFeesText = grossFeesElement.getText();
		grossFees = new BigDecimal(grossFeesText.replaceAll("[€$£,a-zA-Z\\s]+", ""));
	}
	
	public void calcGrossFeesInstalment()
	{
		instalmentRadioButton = webDriver.findElement(instalmentRadioLocator);
		instalmentRadioButton.click();
		try
		{
			Thread.sleep(20000);  // prevent abrupt termination of javascript execution
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		grossFeesElement = webDriver.findElement(grossFeesElementLocator);
		grossFeesText = grossFeesElement.getText();
		grossFees = new BigDecimal(grossFeesText.replaceAll("[€$£,a-zA-Z\\s]+", ""));
	}
	
	public void calcGrossFeesBasicOnly()
	{
		grossFeesElement = webDriver.findElement(grossFeesElementLocator);
		grossFeesText = grossFeesElement.getText();
		grossFees = new BigDecimal(grossFeesText.replaceAll("[€$£,a-zA-Z\\s]+", ""));
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

