package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class InstitutionCourseListPage extends UnipupilWebPage
{
	WebElement courseTitle;
	WebElement editIcon;
	
	//By courseTitleBlocksLocator = By.cssSelector("div.view-content:nth-of-type(2) > div:nth-of-type(1)");
	By courseTitleBlocksLocator = 	By.cssSelector("div.class_dtl");
    By courseTitleLocator = By.cssSelector("h3 > a");
    By editIconLocator = By.cssSelector("img[title='Edit']");
    
    WebDriverWait wait;

	public InstitutionCourseListPage()
	{
		System.out.println("InstitutionCourseListPage default constructor");
	}
	
	public InstitutionCourseListPage(WebDriver driver)
	{
		super(driver);
		System.out.println("InstitutionCourseListPage constructor");
		
	}
	
	public void editCourse(String courseName)
	{
		Select itemsPerPage = new Select(webDriver.findElement(By.id("edit-items-per-page")));
		itemsPerPage.selectByValue("128");

		try{
			Thread.sleep(50000);
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		List<WebElement> courseTitleBlocks = webDriver.findElements(courseTitleBlocksLocator);
		System.out.println("courseTitleBlocks: " + courseTitleBlocks.size() + " items");
		for(WebElement courseTitleBlock : courseTitleBlocks)
		{
			WebElement courseTitle = courseTitleBlock.findElement(courseTitleLocator);
			if(courseTitle.getText().toUpperCase().equals(courseName.toUpperCase()))
			{
				System.out.println("course title found");
				editIcon = courseTitleBlock.findElement(editIconLocator);
				editIcon.click();
				break;
			}
		}
	}
}
