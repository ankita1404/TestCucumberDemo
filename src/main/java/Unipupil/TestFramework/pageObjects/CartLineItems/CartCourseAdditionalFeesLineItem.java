package Unipupil.TestFramework.pageObjects.CartLineItems;

import java.math.BigDecimal;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import java.util.Iterator;
//import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Unipupil.TestFramework.utilities.ThreadSleep;

public class CartCourseAdditionalFeesLineItem extends CartLineItem {
	WebElement additionalFeesTitleElement;
	WebElement cartLineAdditionalFeesElement;
	WebElement intitutionTitleElement;
	WebElement cartProductNameElement;
	WebElement institutionTitle;
	WebElement cartLineQuantityElement;
	
	WebDriverWait wait;

	By cartProdUnitPriceLocator =   
			By.cssSelector("table.sticky-enabled > tbody > tr:nth-of-type(1) > td:nth-of-type(5) > span");
	By cartLinePriceLocator =       
			By.cssSelector("table.sticky-enabled > tbody > tr:nth-of-type(1) > td:nth-of-type(6) > span");
	By cartProdNameLocator =        
			By.cssSelector("table.sticky-enabled > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > a:nth-of-type(1)");
	By additionalFeesTitleLocator = 
			By.cssSelector("table.sticky-enabled > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > div > ul > li:nth-of-type(1)");
	By institutionTitleLocator =    
			By.cssSelector("table.sticky-enabled > tbody > tr:nth-of-type(1) > td:nth-of-type(3) > div > ul > li:nth-of-type(2)");

	String[] tokens;
	String[] linePriceTokens;

	String cartProductName;
	String additionalFeesTitle;
	String additionalFeesText;
	String cartUnitPriceText;

	BigDecimal cartLinePrice;
	BigDecimal additionalFee;
	BigDecimal cartLineAdditionalFees;
	BigDecimal cartProdUnitPrice;

	public CartCourseAdditionalFeesLineItem(WebDriver driver) {
		super(driver);
		System.out.println("CartCourseAdditionalFeesLineItem constructor");
		wait = new WebDriverWait(driver,60);
	}

	public void findLineItemElements() {
		//institutionTitle = wait.until(ExpectedConditions.presenceOfElementLocated(institutionTitleLocator));
		institutionTitle = webDriver.findElement(institutionTitleLocator);
		while(!(institutionTitle.isDisplayed())){
			System.out.println("Finding institutionTitle");
			ThreadSleep.sleep();
		}

		cartProductNameElement = webDriver.findElement(cartProdNameLocator);
		cartProductName = cartProductNameElement.getText().toUpperCase().toUpperCase();
		cartProductUnitPriceElement = webDriver.findElement(cartProdUnitPriceLocator);
		cartUnitPriceText = cartProductUnitPriceElement.getText();
		cartProdUnitPrice = new BigDecimal(cartUnitPriceText.replaceAll("[€,]+",""));
		System.out.println("CartProductUnitPrice: "+cartProdUnitPrice);
		additionalFeesTitleElement = webDriver.findElement(additionalFeesTitleLocator);
		additionalFeesTitle = additionalFeesTitleElement.getText();
		cartLinePriceElement = webDriver.findElement(cartLinePriceLocator);
		System.out.println(cartLinePriceElement.getText());
		System.out.println("probando cartline");
		tokens = cartLinePriceElement.getText().toUpperCase().split("\n");// split text containing <br></br>
		String linePriceText = tokens[0];
		cartLinePrice = new BigDecimal(linePriceText.replaceAll("[€,]+",""));
		additionalFeesText = tokens[1];
		cartLineAdditionalFees = new BigDecimal(additionalFeesText.replaceAll("[€,]+",""));
		System.out.println(cartLinePrice+" "+cartLineAdditionalFees);
	}

	public String getCartLineProductName() {
		return cartProductName;
	}

	public String getAdditionalFeesTitle() {
		return additionalFeesTitle;
	}

	public BigDecimal getProductUnitPrice() {
		return cartProdUnitPrice;
	}

	public BigDecimal getLinePrice() {
		return cartLinePrice;
	}

	public String getAdditionalFeesText() {
		return additionalFeesText;
	}

	public BigDecimal getAdditionalFees() {
		return cartLineAdditionalFees;
	}

	/*
	 * public BigDecimal getCartLineQuantity() { cartLineQuantityElement =
	 * webDriver.findElement(By.xpath(cartQuantityXpath)); BigDecimal
	 * cartLineQuantity = new
	 * BigDecimal(cartLineQuantityElement.getAttribute("value")); return
	 * cartLineQuantity; }
	 */

	public String getCartUnitPriceText() {
		return cartUnitPriceText;
	}

	public String getInstitutionTitle() {
		return institutionTitle.getText();
	}
}
