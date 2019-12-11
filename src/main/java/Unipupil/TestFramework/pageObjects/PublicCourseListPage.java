package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Unipupil.TestFramework.utilities.ThreadSleep;

public class PublicCourseListPage extends UnipupilWebPage
{
	WebElement courseTitle;
	Select itemsPerPage;
	WebDriverWait wait;
	By itemsPerPageSelector = By.cssSelector("select#edit-items-per-page");
	
	public PublicCourseListPage()
	{
		System.out.println("PublicCourseListPage default constructor");
	}
	
	public PublicCourseListPage(WebDriver driver)
	{
		super(driver);
		System.out.println("PublicCourseListPage constructor");
	}
	
	public void selectCourse(String courseName)
	{
		wait = new WebDriverWait(webDriver,20);
		//itemsPerPage = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(itemsPerPageSelector)));
		itemsPerPage = new Select(webDriver.findElement(itemsPerPageSelector));
		itemsPerPage.selectByValue("128");
		try{
			Thread.sleep(10000);
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		//courseTitle = webDriver.findElement(By.linkText(courseName));
		courseTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(courseName)));
		while(!(courseTitle.isDisplayed())){
			System.out.println("Finding courseTitle");
		    ThreadSleep.sleep();
		}
	    courseTitle.click();
	}
}
