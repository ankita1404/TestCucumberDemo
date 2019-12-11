package Unipupil.TestFramework.pageObjects.CheckoutLineItems;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
/*import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;*/


public class CheckoutCourseAdditionalFeesLineItem extends CheckoutLineItem
{
	WebElement institutionTitleElement;
	WebElement checkoutLineQuantityElement;
	WebElement productNameElement;
	WebElement checkoutAdditionalFeesTitleElement;
	WebElement checkoutInstitutionTitle;
	WebElement productUnitPriceElement;
	WebElement checkoutLinePriceElement;
	
	//String checkoutProdNameXpath = ".//*[@id='cart-pane']/div/table[2]/tbody/tr[1]/td[1]/a";
	String productNameXpath = ".//td[@class ='products']/a[1]";
	//String productNameXpat = ".//*[@id='cart-pane']/div/table/tbody/tr[1]/td[1]/a[1]";
	//String checkoutAddFeesTitleXpath = ".//*[@id='cart-pane']/div/table[2]/tbody/tr[1]/td[1]/div/ul/li";
	String checkoutAddFeesTitleXpath = ".//*[@id='cart-pane']/div/table/tbody/tr[1]/td[1]/div/ul/li[1]";
	String checkoutInstTitleXpath =    ".//*[@id='cart-pane']/div/table/tbody/tr[1]/td[1]/div/ul/li[2]";
	//String checkoutQtyXpath = ".//*[@id='cart-pane']/div/table[2]/tbody/tr[1]/td[2]";
	//String checkoutProdUnitPriceXpath = ".//*[@id='cart-pane']/div/table[2]/tbody/tr[1]/td[3]";
	String prodUnitPriceXpath = ".//*[@id='cart-pane']/div/table/tbody/tr[1]/td[3]";
	//String checkoutLinePriceXpath = ".//*[@id='cart-pane']/div/table[2]/tbody/tr[1]/td[4]/span";
	String checkoutLinePriceXpath = ".//*[@id='cart-pane']/div/table/tbody/tr[1]/td[4]/span";
	                                 
	
	String[] tokens;
	String[] linePriceTokens;
	
	String productName;
	String additionalFeesTitle;
	String institutionTitle;
	
	BigDecimal linePrice;
	BigDecimal additionalFee;
	BigDecimal lineAdditionalFees;
	BigDecimal productUnitPrice;
	
	public CheckoutCourseAdditionalFeesLineItem()
	{
		System.out.println("CheckoutCourseAdditionalFeesLineItem default constructor");
	}
	
	public CheckoutCourseAdditionalFeesLineItem(WebDriver driver)
	{
		super(driver);
		System.out.println("CheckoutCourseAdditionalFeesLineItem constructor");
	}
	
	public void findLineItemElements()
	{
		productNameElement = webDriver.findElement(By.xpath(productNameXpath));
		productName = productNameElement.getText();
		System.out.println(productName);
		
		String productUnitPriceText;
		productUnitPriceElement = webDriver.findElement(By.xpath(prodUnitPriceXpath));
		System.out.println(productUnitPriceElement.getText());
		productUnitPriceText = productUnitPriceElement.getText().split("\n")[0].replaceAll("[€,]+","");
		System.out.println("***** "+productUnitPriceText+"*****");
		productUnitPrice = new BigDecimal(productUnitPriceText);
		System.out.println(productUnitPrice+"*****");
		
		checkoutAdditionalFeesTitleElement = webDriver.findElement(By.xpath(checkoutAddFeesTitleXpath));
		additionalFeesTitle = checkoutAdditionalFeesTitleElement.getText();
		
		checkoutLinePriceElement = webDriver.findElement(By.xpath(checkoutLinePriceXpath));
		tokens = checkoutLinePriceElement.getText().split("\n");// split text containing <br></br>\n"
		
		String linePriceText = tokens[0];
		linePrice = new BigDecimal(linePriceText.replaceAll("[€,]+", ""));
		
		String lineAdditionalFeesText = tokens[1];
		lineAdditionalFees = new BigDecimal(lineAdditionalFeesText.replaceAll("[€,]+",""));
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
		institutionTitleElement = webDriver.findElement(By.xpath(checkoutInstTitleXpath));
		institutionTitle = institutionTitleElement.getText();
		return institutionTitle;
	}
}
