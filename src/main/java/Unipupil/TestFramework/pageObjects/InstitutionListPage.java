package Unipupil.TestFramework.pageObjects;

//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;


public class InstitutionListPage extends UnipupilWebPage
{
	List<WebElement> institutionTitleBlocks;
	WebElement institutionNameElement;
	
	//String institutionNameXpath = 
			//".//*[@id='block-system-main']/div/div/div[2]/div/div/span/div/div[2]/h2/span/a";
	
	By institutionTitleBlocksLocator = By.cssSelector("div.inst_dtl_block");
	By institutionNameLocator = By.cssSelector("h2 > span > a");
	
	public InstitutionListPage()
	{
		System.out.println("InstitutionListPage default constructor");
	}
	
	public InstitutionListPage(WebDriver driver)
	{
		super(driver);
		System.out.println("InstitutionListPage constructor");
	}
	
	public void selectInstitution(String eduInstName)
	{

		System.out.println("Method selectInstitution");
		System.out.println("Parameter "+eduInstName);
		institutionTitleBlocks = webDriver.findElements(institutionTitleBlocksLocator);
		System.out.println("Number of title blocks found: " + institutionTitleBlocks.size());
		for(WebElement instTitleBlock : institutionTitleBlocks)
		{
			institutionNameElement = instTitleBlock.findElement(institutionNameLocator);
			System.out.println(institutionNameElement.getText());
			if(institutionNameElement.getText().toUpperCase().equals(eduInstName.toUpperCase()))
			{
				institutionNameElement.click();
			    break;
			}
		}
		 
	}

}
