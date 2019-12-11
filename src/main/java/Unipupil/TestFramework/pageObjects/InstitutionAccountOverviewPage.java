package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import Unipupil.TestFramework.pageObjects.InstitutionAccountTableRows.InstitutionAccountTableRow;


public class InstitutionAccountOverviewPage extends UnipupilWebPage{
	
String orderNumber;
	
	WebElement orderTableRow;
	List<WebElement> orderTableRows;
	List<WebElement> orderIDs;
	
	By orderTableRowsLocator = By.cssSelector("table.views-table.cols-13 > tbody > tr");
	By orderIDsLocator = By.cssSelector("td:nth-of-type(1)");
	
	boolean instTitleFound;
	boolean orderNumberFound;
	
	InstitutionAccountTableRow institutionAccountTableRow;
	
	public InstitutionAccountOverviewPage()
	{
		System.out.println("InstitutionAccountOverviewPage default constructor");
	}
	
	public InstitutionAccountOverviewPage(WebDriver driver)
	{
		super(driver);
		System.out.println("InstitutionAccountOverviewPage constructor");
	}
	
	public void findInstitutionAccountEntry(String orderNumber)
	{
		System.out.println(this.getClass()+": " + "'findAgentAccountEntry' running");
		System.out.println(AgentProfilePage.class);
		orderNumberFound = false;
		orderTableRows = webDriver.findElements(orderTableRowsLocator);
		System.out.println(orderTableRows.size());
		for(WebElement tableRow : orderTableRows)
		{
			orderIDs = tableRow.findElements(orderIDsLocator);
			System.out.println(orderIDs.size());
			for(WebElement orderIDAnchor : orderIDs){
			    System.out.println(orderIDAnchor.getText());
			    if(orderIDAnchor.getText().toUpperCase().equals(orderNumber))
			    {
				    orderNumberFound = true;
				    System.out.println(orderNumberFound);
				    break;
			    }
			}
			if(orderNumberFound)
			{
		        orderTableRow = tableRow;
				break;
			}
		}
		institutionAccountTableRow = new InstitutionAccountTableRow(orderTableRow);
		
	}
	
	public WebElement getTableRow()
	{
		return orderTableRow;
	}

}
