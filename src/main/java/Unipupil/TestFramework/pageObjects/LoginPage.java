package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends UnipupilWebPage
{
	//WebDriver driver;
	
	String homePageUrl = "https://unipupil.com";
	String loginPageUrl = "https://unipupil.com/user/login";
	String username;
	String password;
	
	String forgotPwdXpath = ".//*[@id='user-login']/div/div[1]/div[2]/div/a";
	String signupXpath = ".//*[@id='user-login']/div/div[1]/div[4]/span/a";
	
	WebElement usernameField;
	WebElement passwordField;
	WebElement loginSubmit;
	
	WebDriverWait wait;
	
	
	
	// By objects for locating web elements
	By usernameFieldLocator = By.cssSelector("input#edit-name");
	By passwordFieldLocator = By.cssSelector("input#edit-pass");
	By submitButtonLocator = By.id("edit-submit");
	By forgotPasswordLinkLocator = By.cssSelector("div.description > a"); //xpath(forgotPwdXpath);
	By signup = By.cssSelector("li.logged > div > a#grnBtnl");//xpath(signupXpath);
	
	// Page default constructor
	public LoginPage()
	{
		System.out.println("LoginPage constructor");
	}
	
	// Page constructor
	public LoginPage(WebDriver driver)
	{
		super(driver);
		wait = new WebDriverWait(webDriver,30);
		System.out.println("LoginPage constructor");
	}
	
	
	
	public void enterUsername(String username)
	{
		System.out.println("username: " + username);
		//usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(usernameFieldLocator));
		usernameField = webDriver.findElement(usernameFieldLocator);
	    usernameField.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		System.out.println("password: " + password);
		//passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(passwordFieldLocator));
		passwordField = webDriver.findElement(passwordFieldLocator);
		passwordField.sendKeys(password);
	}
	
	public void clickSubmit()
	{
		loginSubmit = webDriver.findElement(submitButtonLocator);
		loginSubmit.click();
	}
	
	public String getTitle()
	{
		String pageTitle = webDriver.getTitle();
		return pageTitle;
	}
	
	public String getLoginPageUrl()
	{
		return loginPageUrl;
	}
	
	public void submitLoginDetails(String username, String password)
	{
		enterUsername(username);
		enterPassword(password);
		clickSubmit();
		
	}

}
