package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Homepage extends UnipupilWebPage

//public class Homepage
{	
	//WebDriver driver;
	
	String homePageUrl = "https://unipupil.com/";
	String username;
	String password;
	
	WebElement loginLink;
	
	String cityXpath =   ".//*[@id='block-views-2538dccb0273ba43beeefaddc377fbe3']/div/div/div[1]/div/h1/span[1]";
	String featBlkCityXpath = ".//*[@id='block-views-block-city-list-featured-block']/div/div/div[1]/div/h1/span[1]";
	String regionXpath = ".//*[@id='block-views-featured-institution-block']/div/div/div[1]/div/span[1]";
	String regionBlockXpath = ".//*[@id='block-views-featured-institution-block']/div/div/div[2]";
	
	By city = By.xpath(cityXpath);
	By blkCity = By.xpath(featBlkCityXpath);
	By regBlk = By.xpath(regionBlockXpath);
	
	//  Default page constructor
	public Homepage()
	{
		System.out.println("Homepage default constructor");
	}
	
	// Page constructor
	public Homepage(WebDriver driver)
	{
		//super.driver = driver;
		super(driver);
		//this.driver = driver;
		System.out.println("Homepage constructor");
	}
	
	public String getHomepageUrl()
	{
		return homePageUrl;
	}
	

}
