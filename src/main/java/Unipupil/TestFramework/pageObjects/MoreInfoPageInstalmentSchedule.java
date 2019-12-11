package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
/*import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.List;*/

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class MoreInfoPageInstalmentSchedule extends UnipupilWebPage {
	
	String cartURL = "https://unipupil.com/en/cart";
	
    List<WebElement> instalmentScheduleLines;
    WebElement instalmentNumberElement;
    WebElement instalmentPercentElement;
    WebElement instalmentDateElement;
    WebElement instalmentAmountElement;
    WebElement courseTotalLabelElement;
    WebElement courseTotalElement;

    By instalmentScheduleLinesLocator = By.cssSelector("table.instalment_table_node > tr");
    By instalmentNumberLocator = By.cssSelector("tbody > td:nth-of-type(1");
    By instalmentPercentLocator = By.cssSelector("tbody > td:nth-of-type(2)");
    By instalmentDateLocator = By.cssSelector("tbody > td:nth-of-type(3)");
    By instalmentAmountLocator = By.cssSelector("tbody > td:nth-of-type(4)");
    By courseTotalLabelLocator = By.cssSelector("");
    By courseTotalLocator = By.cssSelector("");
    
    BigDecimal instalmentNumber;
    BigDecimal instalmentPercent;
    BigDecimal instalmentAmount;
    
    String instalmentDate;
        

    public MoreInfoPageInstalmentSchedule()
	{
		System.out.println("InstalmentSchedule default constructor");
	}
	
	public MoreInfoPageInstalmentSchedule(WebDriver driver)
	{
		super(driver);
		System.out.println("InstalmentSchedule constructor");
	}
	
	/*public void findWebElements(WebDriver driver)
	{
		instalmentScheduleLines = driver.findElements(instalmentScheduleLinesLocator);
		for(int i = 1; i < instalmentScheduleLines.size()+1;i++){
		     
		}
	}*/
	
	public BigDecimal getInstalmentNumber()
	{
		return instalmentNumber;
	}
	
	public BigDecimal getInstalmentPercent()
	{
		return instalmentPercent;
	}
	
	public String getInstalmentDate()
	{
		return instalmentDate;
	}
	
	public BigDecimal getInstalmentAmount()
	{
		return instalmentAmount;
	}
    

}
