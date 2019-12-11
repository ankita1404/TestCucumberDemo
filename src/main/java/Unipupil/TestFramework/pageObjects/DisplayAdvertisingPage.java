package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DisplayAdvertisingPage extends UnipupilWebPage
{
	
	
	public DisplayAdvertisingPage()
	{
		System.out.println("DisplayAdvertisingPage default constructor running");
	}
	
	public DisplayAdvertisingPage(WebDriver driver)
	{
		super(driver);
		System.out.println("DisplayAdvertisingPage constructor running");
	}

}
