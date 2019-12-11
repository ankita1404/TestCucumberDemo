package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.Keys;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class DisplayAdvertisingEditPage extends UnipupilWebPage
{
	
	
	public DisplayAdvertisingEditPage()
	{
		System.out.println("DisplayAdvertisingEditPage default constructor running");
	}
	
	public DisplayAdvertisingEditPage(WebDriver driver)
	{
		super(driver);
		System.out.println("DisplayAdvertisingEditPage constructor running");
	}
	

}
