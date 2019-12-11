package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;

import Unipupil.TestFramework.pageObjects.AgentAccountTableRows.AgentAccountTableRow;

import java.util.List;

import Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows.InstitutionAccountTableRow;
import Unipupil.TestFramework.pageObjects.StudentAccountTableRows.StudentAccountTableRow;




public class InstitutionProfilePage extends UnipupilWebPage{

	//WebDriver driver;

	//WebElements

	WebElement institutionTitleBlock;
	WebElement institutionNameElement;
	WebElement sellingIcon;
	WebElement accountIcon;

	List<WebElement> institutionTitleBlocks;
	String homePageUrl = "https://unipupil.com/";
	String userProfilePageUrl = "https://unipupil.com/users/unipupil-university-sample";
		//Xpath variables
	String myAccountXpath = ".//*[@id='block-block-7']/div/div/span[2]/a";

	By institutionNameLocator = By.cssSelector("div.leftside_links > div:nth-of-type(2) > span > a");
	By institutionTitleBlocksLocator = By.cssSelector("table.views-view-grid.cols-2 > tbody > tr > td");
	By sellingIconLocator = By.cssSelector("div:nth-of-type(2) > a:nth-of-type(1) > img");
	By accountIconLocator = By.cssSelector("div:nth-of-type(3) > a:nth-of-type(4) > img");
	By myaccount = By.xpath(myAccountXpath);
	By logout = By.linkText("Logout");

    String orderNumber;

	InstitutionAccountTableRow institutionAccountTableRow;

	// Page default constructor
	public InstitutionProfilePage()
	{
		System.out.println("InstitutionProfilePage default constructor");
	}

	// Page constructor
	public InstitutionProfilePage(WebDriver driver)
	{
		super(driver);
		System.out.println("InstitutionProfilePage constructor");
		//super.driver = driver;
	}

	public String getTitle()
	{
		return webDriver.getTitle();
	}

	public void getCourseList(String edInstName)
	{
		institutionTitleBlocks = webDriver.findElements(institutionTitleBlocksLocator);
		for(WebElement instTitleBlock : institutionTitleBlocks)
		{
			institutionNameElement = instTitleBlock.findElement(institutionNameLocator);
			String getText= institutionNameElement.getText();
			System.out.println(edInstName+" "+getText);
			if(getText.toUpperCase().equals(edInstName.toUpperCase()))
			{
			    sellingIcon = instTitleBlock.findElement(sellingIconLocator);
			    sellingIcon.click();
			    break;
			}
		}
	}

	public void accountOverview(String edInstName)
	{
		institutionTitleBlocks = webDriver.findElements(institutionTitleBlocksLocator);
		for(WebElement instTitleBlock : institutionTitleBlocks)
		{
			institutionNameElement = instTitleBlock.findElement(institutionNameLocator);
			String getText= institutionNameElement.getText();
			System.out.println(edInstName+" "+getText);
			if(getText.toUpperCase().equals(edInstName.toUpperCase()))
			{
		        accountIcon = instTitleBlock.findElement(accountIconLocator);
		        accountIcon.click();
		        break;
			}
		}
	}

	public String getProfilePageUrl()
	{
		return userProfilePageUrl;
	}

	public void clickMyAccount(){
		webDriver.findElement(myaccount).click();
	}

	public void clickLogout()
	{
		webDriver.findElement(logout).click();
	}

}


