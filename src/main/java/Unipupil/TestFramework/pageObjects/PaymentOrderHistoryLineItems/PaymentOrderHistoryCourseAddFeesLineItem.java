package Unipupil.TestFramework.pageObjects.PaymentOrderHistoryLineItems;

import java.math.BigDecimal;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PaymentOrderHistoryCourseAddFeesLineItem extends PaymentOrderHistoryLineItem{
	
	WebElement orderHistoryLineQuantityElement;
	WebElement orderHistoryProductName;
	WebElement orderHistoryAdditionalFeesTitle;
	WebElement orderHistoryInstitutionTitle;
	WebElement orderHistoryProdUnitPriceElement;
	WebElement orderHistoryLinePriceElement;
	WebElement orderSubTotalElement;
	WebElement orderHistoryTotalElement;
	WebElement productDescriptionElement;
	WebElement productNameElement;
	
	By orderHistoryProdNameLocator = By.cssSelector("div#order-pane-products > table > tbody > tr > td:nth-of-type(1) > a");
	By orderHistoryAddFeesDescriptionLocator = By.cssSelector("div#order-pane-products > table > tbody > tr > td:nth-of-type(1)");
	By orderHistoryLineQuantityLocator = By.cssSelector("div#order-pane-products > table > tbody > tr > td:nth-of-type(2)");
	By orderHistoryProdUnitPriceLocator = By.cssSelector("div#order-pane-products > table > tbody > tr > td:nth-of-type(3) > span");
	By orderHistoryLinePriceLocator =     By.cssSelector("div#order-pane-products > table > tbody > tr > td:nth-of-type(4) > span");
	
	/*String orderHistoryProdNameXpath = ".//*[@id='order-pane-products']/table/tbody/tr/td[1]/a";
	String orderHistoryAddFeesDescriptionXpath = ".//*[@id='order-pane-products']/table/tbody/tr/td[1]";
	String orderHistoryLineQuantityXpath = ".//*[@id='order-pane-products']/table/tbody/tr/td[2]";
	String orderHistoryProdUnitPriceXpath = ".//*[@id='order-pane-products']/table/tbody/tr/td[3]/span";
	String orderHistoryLinePriceXpath = ".//*[@id='order-pane-products']/table/tbody/tr/td[4]/span";*/
	
	String basicFeeString;
	String additionalFeeString;
	String productName;
	String productDescription;
	
	BigDecimal productUnitPrice;
	BigDecimal lineQuantity;
	BigDecimal linePrice;
	BigDecimal additionalFees;
	
	public PaymentOrderHistoryCourseAddFeesLineItem()
	{
		System.out.println("OrderHistoryPage default constructor");
	}
	
	public PaymentOrderHistoryCourseAddFeesLineItem(WebDriver driver)
	{
		super(driver);
		System.out.println("OrderHistoryPage constructor");
	}
	
	public void findElements()
	{
        //productNameElement = webDriver.findElement(By.xpath(orderHistoryProdNameXpath));
        productNameElement = 
        		wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryProdNameLocator));
        productName = productNameElement.getText();
        System.out.println("productName"+productName);
        //productDescriptionElement = webDriver.findElement(By.xpath(orderHistoryAddFeesDescriptionXpath));
        productDescriptionElement = 
        		wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryAddFeesDescriptionLocator));
		productDescription = productDescriptionElement.getAttribute("textContent");
		System.out.println("productDescription "+productDescription);
		
		//orderHistoryLineQuantityElement = webDriver.findElement(By.xpath(orderHistoryLineQuantityXpath));
				orderHistoryLineQuantityElement = 
						wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryLineQuantityLocator));
				String orderHistoryLineQuantityText = orderHistoryLineQuantityElement.getAttribute("textContent").split("\n")[0].replaceAll("\\W", "");
				lineQuantity = new BigDecimal(orderHistoryLineQuantityText);
				System.out.println("lineQuantity: "+lineQuantity);
		
		//orderHistoryProdUnitPriceElement = webDriver.findElement(By.xpath(orderHistoryProdUnitPriceXpath));
		orderHistoryProdUnitPriceElement = 
				wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryProdUnitPriceLocator));
		String orderHistoryProdUnitPriceString = orderHistoryProdUnitPriceElement.getText();
		String unitPriceString = orderHistoryProdUnitPriceString.split(",")[1].replaceAll("[€$£\\s]+","");
		productUnitPrice = new BigDecimal(unitPriceString);
		System.out.println("productUnitPrice "+productUnitPrice);
		
		//orderHistoryLinePriceElement = webDriver.findElement(By.xpath(orderHistoryLinePriceXpath));
		orderHistoryLinePriceElement = 
				wait.until(ExpectedConditions.presenceOfElementLocated(orderHistoryLinePriceLocator));
		tokens = orderHistoryLinePriceElement.getText().toUpperCase().split("\n"); //fees separated by <br></br>
		String linePriceText = tokens[0].replaceAll("[a-zA-Z€£$\\s,]+", "");
		linePrice = new BigDecimal(linePriceText);
		System.out.println("linePrice "+linePrice);
		additionalFeeString = tokens[1].replaceAll("[a-zA-Z€£$\\s,]+","");
		additionalFees = new BigDecimal(additionalFeeString);
		System.out.println("additionalFees "+additionalFees);
	}
	
	public String getProductDescription()
	{
		return productDescription;
	}
	
	public String getProductName()
	{
		System.out.println("getProductName: "+productName);
		return productName;
	}
	
	public BigDecimal getUnitPrice()
	{
		System.out.println("productUnitPrice: "+productUnitPrice);
		return productUnitPrice;
	}
	
	public BigDecimal getLinePrice()
	{
		System.out.println("getLinePrice: "+linePrice);
		return linePrice;
	}
	
	public BigDecimal getAdditionalFees()
	{
		System.out.println("getAdditionalFees: "+additionalFees);
		return additionalFees;
	}
	
	public BigDecimal getQuantity()
	{
		System.out.println("getQuantity: "+ lineQuantity);
		return lineQuantity;
	}

}
