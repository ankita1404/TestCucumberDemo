package Unipupil.TestFramework.pageObjects.CartLineItems;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class CartCourseOnlyLineItem extends CartLineItem
{
	
	
	public CartCourseOnlyLineItem()
	{
		System.out.println("CartCourseOnlyLineItem default constructor");
	}
	
	public CartCourseOnlyLineItem(WebDriver driver)
	{
		super(driver);
		System.out.println("CartCourseOnlyLineItem constructor");
		
	}
}
