package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SignupPage 
{
	WebDriver driver;
	
	String homePageUrl = "https://unipupil.com/en";
	String loginPageUrl = "https://unipupil.com/en/user/login";
	String username;
	String password;
	
	String forgotPwdXpath = ".//*[@id='user-login']/div/div[1]/div[2]/div/a";
	String signupXpath = ".//*[@id='user-login']/div/div[1]/div[4]/span/a";
	
	WebElement loginSubmit;
	
	
	
	// By objects for locating web elements
	By user = By.id("edit-name");
	By pass = By.id("edit-pass");
	By submit = By.id("edit-submit");
	By forgotPassword = By.xpath(forgotPwdXpath);
	By signup = By.xpath(signupXpath);
	
	// Page constructor
	public SignupPage(String username, String password, WebDriver driver)
	{
		System.out.println("LoginPage constructor");
		this.driver = driver;
		this.username = username;
		this.password = password;
	}
	
	
	public void enterUsername(String username)
	{
		driver.findElement(user).sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		driver.findElement(pass).sendKeys(password);
	}
	
	public void clickSubmit()
	{
		driver.findElement(submit).click();
	}
	
	public String getTitle()
	{
		String pageTitle = this.driver.getTitle();
		return pageTitle;
	}
	
	public String getLoginPageUrl()
	{
		return loginPageUrl;
	}
	
	public void unipupilLogin()
	{
		this.enterUsername(username);
		this.enterPassword(password);
		this.clickSubmit();
		
	}

}
