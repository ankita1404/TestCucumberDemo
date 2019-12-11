package Unipupil.TestFramework.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;


import Unipupil.TestFramework.pageObjects.AgentAccountTableRows.AgentAccountTableRow;


public class AgentProfilePage extends UnipupilWebPage{
	
	WebDriver driver;
	
	List<WebElement> totalPaidElements;
	
	String homePageUrl = "https://unipupil.com";
	//String userProfilePageUrl = "https://unipupil.com/en/users/promo-agent";
	String userProfilePageUrl = "https://unipupil.com/user";

	String myAccountXpath = ".//*[@id='block-block-7']/div/div/span[2]/a";
	//By agentRevenueReportTabLocator = By.cssSelector("div.panel-pane.pane-custom pane-1 > div > div > ul > li:nth-of-type(1)");
	By orderTableRowsLocator = By.cssSelector("table.views-table.cols-11 > tbody > tr");
	By orderIDsLocator = By.cssSelector("td:nth-of-type(1)");
	
	By totalRevenueLocator = By.cssSelector("div.view-footer > table > tbody > tr > td:nth-of-type(7)");
	
	By myaccount = By.xpath(myAccountXpath);
	By logout = By.linkText("Logout");
	
    String orderNumber;
	
	WebElement orderTableRow;
	List<WebElement> orderTableRows;
	List<WebElement> orderIDs;
	
	boolean instTitleFound;
	boolean orderNumberFound;
	
	AgentAccountTableRow agentAccountTableRow;
	
	//BigDecimal agentCommission;
	//BigDecimal institutionCommission;
	
	// Page constructor
	public AgentProfilePage(WebDriver driver)
	{
		super(driver);
		System.out.println("AgentProfilePage constructor");
	}
	
	// Page default constructor
		public AgentProfilePage()
		{
			System.out.println("AgentProfilePage default constructor");
		}
	
	public String getTitle()
	{
		String pageTitle = webDriver.getTitle();
		return pageTitle;
	}
	
	public String getProfilePageUrl()
	{
		return userProfilePageUrl;
	}
	
	public BigDecimal calcTotalRevenue()
	{
		BigDecimal totalPaid;
		BigDecimal totalRevenue = new BigDecimal(0);
		WebElement totalPaidElement;
		String totalPaidText;
		totalPaidElements = webDriver.findElements(By.cssSelector("td[class='views-field views-field-php']"));
		totalPaidElements = webDriver.findElements(By.cssSelector("td.views-field.views-field-php"));
		System.out.println("totalPaidElements size: "+totalPaidElements.size());
		Iterator<WebElement> totalPaidElementsIterator = totalPaidElements.iterator();
		System.out.println(totalPaidElementsIterator.hasNext());
		while(totalPaidElementsIterator.hasNext())
		{
			totalPaidElement = totalPaidElementsIterator.next();
			totalPaidText = totalPaidElement.getText().toUpperCase().replaceAll("[a-zA-Z€,\\s]+","");
			System.out.println(totalPaidText);
			totalPaid = new BigDecimal(totalPaidText);
			System.out.println(totalPaid);
			totalRevenue = totalRevenue.add(totalPaid);
			System.out.println(totalRevenue);
		}
		System.out.println("calcTotalRevenue: "+totalRevenue);
		return totalRevenue;
	}
	
	public BigDecimal displayedTotalRevenue()
	{
		WebElement displayedTotalRevenueElement;
		BigDecimal displayedTotalRevenue;
		String displayedTotalRevenueText;
		displayedTotalRevenueElement = webDriver.findElement(totalRevenueLocator);
		displayedTotalRevenueText = displayedTotalRevenueElement.getText();
		System.out.println("displayedTotalRevenueText: ***" + displayedTotalRevenueText+"***");
		System.out.println("***"+displayedTotalRevenueText.split("€")[0]+"***");
		System.out.println("***"+displayedTotalRevenueText.split("€")[1]+"***");
		displayedTotalRevenueText = displayedTotalRevenueText.split("€")[1].replaceAll("[,\\s]+","");
		System.out.println(displayedTotalRevenueText);
		displayedTotalRevenue = new BigDecimal(displayedTotalRevenueText);
		System.out.println("displayedTotalRevenue: "+displayedTotalRevenue);
		return displayedTotalRevenue;
	}
	
	public void findAgentAccountEntry(String orderNumber)
	{
		System.out.println(this.getClass()+": " + "'findAgentAccountEntry' running");
		System.out.println(AgentProfilePage.class);
		WebElement agentRevReportTab;
		//agentRevReportTab = webDriver.findElement(agentRevenueReportTabLocator);
		//agentRevReportTab.click();
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
		agentAccountTableRow = new AgentAccountTableRow(orderTableRow);
		
	}
	
	public WebElement getTableRow()
	{
		return orderTableRow;
	}
	
}
