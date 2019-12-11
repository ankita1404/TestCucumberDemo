package Unipupil.TestFramework.pageObjects.ReviewOrderLineItems;

import java.math.BigDecimal;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;


public class ReviewOrderCourseAdditionalFeesLineItem extends ReviewOrderLineItem
{
	
	//String productNameXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table[2]/tbody/tr/td[1]/a";
	String productNameXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table/tbody/tr/td[1]/a[1]";
    //String additionalFeesTitleXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table[2]/tbody/tr/td[1]/div/ul/li";
    String additionalFeesTitleXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table/tbody/tr/td[1]/div/ul/li[1]";
    String institutionTitleXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table/tbody/tr/td[1]/div/ul/li[2]";
    //String productUnitPriceXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table[2]/tbody/tr/td[3]";
    String productUnitPriceXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table/tbody/tr/td[3]";
    //String linePriceXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table[2]/tbody/tr/td[4]/span";
    String linePriceXpath = ".//*[@id='block-system-main']/div/table/tbody/tr[2]/td/table/tbody/tr/td[4]/span";
    
    WebElement productNameElement;
    //WebElement lineQuantityElement;
	WebElement additionalFeesTitleElement;
	WebElement institutionTitleElement;
	WebElement productUnitPriceElement;
	WebElement linePriceElement;
	
	String reviewOrderProductName;
	String productName;
	String additionalFeesTitle;
	String institutionTitle;
	
	BigDecimal linePrice;
	BigDecimal additionalFee;
	BigDecimal lineAdditionalFees;
	BigDecimal productUnitPrice;
	
	
	public ReviewOrderCourseAdditionalFeesLineItem()
	{
		System.out.println("ReviewOrderCourseAdditionalFeesLineItem default constructor");
	}
	
	public ReviewOrderCourseAdditionalFeesLineItem(WebDriver driver)
	{
		super(driver);
		System.out.println("ReviewOrderCourseAdditionalFeesLineItem constructor");
	}
	
	public void findLineItemElements()
	{
		productNameElement = webDriver.findElement(By.xpath(productNameXpath));
		productName = productNameElement.getText();
		System.out.println(productName);
		additionalFeesTitleElement = webDriver.findElement(By.xpath(additionalFeesTitleXpath));
		additionalFeesTitle = additionalFeesTitleElement.getText();
		
		productUnitPriceElement = webDriver.findElement(By.xpath(productUnitPriceXpath));
		String productUnitPriceText = productUnitPriceElement.getText();
		System.out.println(productUnitPriceText);
		productUnitPriceText = productUnitPriceText.split("\n")[0].replaceAll("[€,]","");
		productUnitPrice = new BigDecimal(productUnitPriceText);
		System.out.println("***** "+productUnitPriceText+"*****");
		
		linePriceElement = webDriver.findElement(By.xpath(linePriceXpath));
		tokens = linePriceElement.getText().toUpperCase().split("\n");// split text containing <br></br>\n"
		String linePriceText = tokens[0];
		String additionalFeesText = tokens[1];
		linePrice = new BigDecimal(linePriceText.replaceAll("[€,]+", ""));
		lineAdditionalFees = new BigDecimal(tokens[1].replaceAll("[€,]+", ""));
	}
	
	public String getLineProductName()
	{
		System.out.println(productName);
		return productName;
	}
	
	public String getAdditionalFeesTitle()
	{
		
		return additionalFeesTitle;
	}
	
	public BigDecimal getProductUnitPrice()
	{
		
		return productUnitPrice;
	}
	
	public BigDecimal getLinePrice()
	{
		return linePrice;
	}
	
	
	public BigDecimal getAdditionalFees()
	{
		return lineAdditionalFees;
	}
	
	/*public BigDecimal getCartLineQuantity()
	{
		cartLineQuantityElement = webDriver.findElement(By.xpath(cartQuantityXpath));
		BigDecimal cartLineQuantity = new BigDecimal(cartLineQuantityElement.getAttribute("value"));
		return cartLineQuantity;
	} */
	
	public String getInstitutionTitle()
	{
		institutionTitleElement = webDriver.findElement(By.xpath(institutionTitleXpath));
		institutionTitle = institutionTitleElement.getText();
		return institutionTitle;
	}
	

}
