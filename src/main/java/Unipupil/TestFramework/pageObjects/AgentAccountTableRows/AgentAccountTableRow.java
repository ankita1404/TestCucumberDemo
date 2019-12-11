package Unipupil.TestFramework.pageObjects.AgentAccountTableRows;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Unipupil.TestFramework.pageObjects.AgentProfilePage;

//import org.openqa.selenium.firefox.FirefoxDriver;
import java.math.BigDecimal;

public class AgentAccountTableRow
{
	
	//WebDriver webDriver;
	WebElement orderTableRow;
	WebElement purchaseDateElement;
	WebElement courseTitleElement;
	WebElement startDateElement;
	WebElement finishDateElement;
	WebElement coursePriceElement;
	WebElement totalCommissionPercentElement;
	WebElement agentCommissionPercentElement;
	WebElement totalCommissionPaidElement;
	
	String purchaseDate;
	String courseTitle;
	String startDate;
	String finishDate;
	String coursePriceText;
	String totalCommissionText;
	String agentCommissionPercentText;
	String totalCommissionPercentText;
	
	By purchaseDateLocator = By.cssSelector("td.views-field.views-field-created");
	By courseTitleLocator = By.cssSelector("td.views-field.views-field-php-4 > div");
	By coursePriceLocator = By.cssSelector("td.views-field.views-field-php-7");
	By totalCommissionPercentLocator = By.cssSelector("td.views-field.views-field-php-3");
	By agentCommissionPercentLocator = By.cssSelector("td.views-field.views-field-php-2");
	By totalCommissionPaidLocator = By.cssSelector("td.views-field.views-field-php");
	
	BigDecimal coursePrice;
	BigDecimal totalCommissionPaid;
	BigDecimal totalCommissionPercent;
	BigDecimal agentCommissionPercent;
	
	public AgentAccountTableRow()
	{
		System.out.println("AgentAccountTableRow default constructor");
	}
	
	public AgentAccountTableRow(WebElement tableRow)
	{
		System.out.println("AgentAccountTableRow constructor");
		//webDriver = driver;
		orderTableRow = tableRow;
	}
	
	public void findElements()
	{
		System.out.println(this.getClass()+": " + "'findAgentAccountEntry' running");
		System.out.println(AgentAccountTableRow.class);
		purchaseDateElement = orderTableRow.findElement(purchaseDateLocator);
		purchaseDate = purchaseDateElement.getText().toUpperCase().trim();
		
		courseTitleElement = orderTableRow.findElement(courseTitleLocator);
		courseTitle = courseTitleElement.getText().toUpperCase().trim();
		
		coursePriceElement = orderTableRow.findElement(coursePriceLocator);
		coursePriceText = coursePriceElement.getText().toUpperCase().trim();
		System.out.println(coursePriceText);
		coursePrice = new BigDecimal(coursePriceText.replaceAll("[€,]+", ""));
		
		totalCommissionPercentElement = orderTableRow.findElement(totalCommissionPercentLocator);
		System.out.println(totalCommissionPercentElement.getText());
		totalCommissionPercent = new BigDecimal(totalCommissionPercentElement.getText().toUpperCase().split("%")[0].trim());
		System.out.println(totalCommissionPercent);
		
		agentCommissionPercentElement = orderTableRow.findElement(agentCommissionPercentLocator);
		System.out.println(agentCommissionPercentElement.getText());
		agentCommissionPercent = new BigDecimal(totalCommissionPercentElement.getText().toUpperCase().split("%")[0].trim());
		System.out.println(agentCommissionPercent);
		
		totalCommissionPaidElement = orderTableRow.findElement(totalCommissionPaidLocator);
		totalCommissionText = totalCommissionPaidElement.getText().toUpperCase().trim();
		System.out.println(totalCommissionText);
		totalCommissionPaid = new BigDecimal(totalCommissionText.replaceAll("[a-zA-Z\\s€,]+", ""));
		System.out.println(totalCommissionText.replaceAll("[a-zA-Z\\s€,]+", ""));
		System.out.println(totalCommissionPaid);
		
	}
	
	public String getPurchaseDate()
	{
		return purchaseDate;
	}
	
	public String getCourseTitle()
	{
		return courseTitle;
	}
	
	public BigDecimal getCoursePrice(){
		return coursePrice;
	}
	
	public BigDecimal getTotalCommissionPaid()
	{
		return totalCommissionPaid;
	}
	
	public BigDecimal getAgentCommissionPercent()
	{
		return agentCommissionPercent;
	}
	
	public BigDecimal getTotalCommissionPercent(){
		return totalCommissionPercent;
	}
}
