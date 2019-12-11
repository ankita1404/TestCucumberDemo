package Unipupil.TestFramework.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Unipupil.TestFramework.pageObjects.StudentAccountTableRows.StudentAccountTableRow;

public class StudentProfilePage extends UnipupilWebPage 
{
	String homePageUrl = "https://unipupil.com/en";
	String userProfilePageUrl = "https://unipupil.com/en/users/scripting-student"; 
	String myAccountXpath = ".//*[@id='block-block-7']/div/div/span[2]/a";

	By myaccount = By.xpath(myAccountXpath);
	By logout = By.linkText("Logout");
	By myCoursesTabSelector = By.cssSelector("a#quicktabs-tab-student_tabs-2");
	By orderTableRowsLocator = By.cssSelector("div#quicktabs-tabpage-student_tabs-2 > div > div.view-content > table > tbody > tr");
	By orderIDAnchorLocator = By.cssSelector("td > a");
	
	String orderNumber;
	
	WebElement orderTableRow;
	List<WebElement> orderTableRows;
	List<WebElement> orderIDAnchors;
	
	boolean instTitleFound;
	boolean orderNumberFound;
	
	StudentAccountTableRow studentAccountTableRow;
	
	// Page constructor
	public StudentProfilePage()
	{
		System.out.println("StudentProfilePage default constructor");
	}
	
	// Page constructor
	public StudentProfilePage(WebDriver driver)
	{
		super(driver);
		System.out.println("StudentProfilePage constructor");
		
	}
	
	/* public String getTitle()
	{
		return super.getTitle();
	}*/
	
	public String getProfilePageUrl()
	{
		return userProfilePageUrl;
	}
	
	public void setOrderNumber(String orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	public void findStudentAccountEntry(String orderNumber)
	{
		System.out.println(this.getClass()+": " + "'findStudentAccountEntry' running");
		System.out.println(StudentProfilePage.class);
		WebElement myCoursesTab;
		myCoursesTab = webDriver.findElement(myCoursesTabSelector);
		myCoursesTab.click();
		orderNumberFound = false;
		
		orderTableRows = webDriver.findElements(orderTableRowsLocator);
		System.out.println(orderTableRows.size());
		
		for(WebElement tableRow : orderTableRows)
		{
			orderIDAnchors = tableRow.findElements(orderIDAnchorLocator);
			System.out.println(orderIDAnchors.size());
			for(WebElement orderIDAnchor : orderIDAnchors){
			    System.out.println(orderIDAnchor.getText());
			    if(orderIDAnchor.getText().toUpperCase().equals(orderNumber))
			    {
				    orderNumberFound = true;
				    break;
			    }
			    System.out.println(orderNumberFound);
			}
			if(orderNumberFound)
			{
		        orderTableRow = tableRow;
				break;
			}
		}
		studentAccountTableRow = new StudentAccountTableRow(orderTableRow);
		
	}
	
	public WebElement getTableRow()
	{
		return orderTableRow;
	}
}
