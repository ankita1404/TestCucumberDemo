package Unipupil.TestFramework.pageObjects;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnipupilWebPage {

	WebDriver webDriver;
	WebDriverWait wait;

	WebElement loginMyAccountLink;
	WebElement signupLogoutLink;
	WebElement searchTextField;

	// By objects for locating web elements
	By loginMyAccountLinkLocator = By.cssSelector("ul#logList > li:nth-of-type(7) > a > span"); //child(6)  > a");
	By CookieAcceptButton = By.xpath("//*[@id='popup-buttons']/button[1]");
	By signupLogoutLinkLocator = By.cssSelector("ul#logList > li:nth-of-type(6) > a");   //child(5) > a");
	By searchOptionLocator = By.cssSelector("select#edit-opt");
	By searchTextFieldLocator = By.cssSelector("input#edit-text");
	By searchSubmitLocator = By.cssSelector("input#edit-sub");
	//By agreeCookiePolicyLocator = By.cssSelector("button.agree-button"); //OK, I agree all cookies
	By agreeCookiePolicyLocator = By.cssSelector("button.agree-button");

	Select quickSearchMenu;
	String optionValue;
	String searchString;
	Actions action;


	public UnipupilWebPage()
	{
		System.out.println("UnipupilWebPage default constructor");
		
	}
	
	public UnipupilWebPage(WebDriver driver)
	{
		webDriver = driver;
	}
	
	/**
	 * Agree cookie policy before doing anything else on the webpage
	 * @throws InterruptedException 
	 */
	public void agreeCookiePolicy() throws InterruptedException {
		
    Thread.sleep(500);
	WebElement cookieAcceptButton = webDriver.findElement(By.xpath("//*[@id='popup-buttons']/button[1]"));
	
	cookieAcceptButton.click();
	}
	
	
	
	private boolean isElementPresent(By by) {
	    try {
	        webDriver.findElement(by);
	        return true;
	        
	    } 
	    catch (NoSuchElementException  e) {
	        return false;
	    }
	}
	
	
	
	
	
	public boolean isCookiePolicyAccepted() {
		wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(CookieAcceptButton)));
		return true;
	}

	public void login()
	{
		signupLogoutLink = wait.until(presenceOfElementLocated(signupLogoutLinkLocator));
		//leftGreenButton = wait.until(arg0);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(leftGreenButtonLocator));
		//leftGreenButton = webDriver.findElement(leftGreenButtonLocator);
		/*while(!(leftGreenButton.isDisplayed())){
			System.out.println("Finding leftGreenButton");
		    ThreadSleep.sleep();
		}*/
		if(signupLogoutLink.getText().toUpperCase().equals("Logout")){
			signupLogoutLink.click();
		}
		//loginLink = wait.until(ExpectedConditions.presenceOfElementLocated(loginLinkLocator));
		//loginMyAccountLink = webDriver.findElement(loginMyAccountLinkLocator);
		
		loginMyAccountLink = webDriver.findElement(By.linkText("Login"));
		while(!(loginMyAccountLink.isDisplayed()))
		{
			System.out.println("Finding login link");
		}
		loginMyAccountLink.click();
	}
	
	public void loginpage() throws InterruptedException {
		
		Thread.sleep(500);
		webDriver.findElement(By.partialLinkText("Login")).click();;
		
		
		
	}
	public void signup()
	{
		//signupLink = wait.until(ExpectedConditions.presenceOfElementLocated(signupLinkLocator));
		signupLogoutLink = webDriver.findElement(signupLogoutLinkLocator);
		while(!(signupLogoutLink.isDisplayed())){
			System.out.println("Finding signup link");
			
		}
		signupLogoutLink.click();
	}

	public void logout()
	{
		//logoutLink = wait.until(ExpectedConditions.presenceOfElementLocated(logoutLinkLocator));
		signupLogoutLink = webDriver.findElement(signupLogoutLinkLocator);
		while(!(signupLogoutLink.isDisplayed())){
			System.out.println("Finding logout link");
			
		}
		signupLogoutLink.click();
	}

	public void myAccount()
	{
		//myAccountLink = wait.until(ExpectedConditions.presenceOfElementLocated(myAccountLinkLocator));
		loginMyAccountLink = webDriver.findElement(loginMyAccountLinkLocator);
		while(!(loginMyAccountLink.isDisplayed())){
			System.out.println("Finding signup link");
			
		}
		loginMyAccountLink.click();
	}

	public String getTitle()
	{
		return webDriver.getTitle();
	}

	public void quickSearch(String optionValue,String searchString)
	{
		//quickSearchMenu = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(searchOptionLocator)));
		quickSearchMenu = new Select(webDriver.findElement(searchOptionLocator));
		quickSearchMenu.selectByVisibleText(optionValue);
		//searchTextField = wait.until(ExpectedConditions.presenceOfElementLocated(searchTextFieldLocator));  // until input box is found
		searchTextField = webDriver.findElement(searchTextFieldLocator);
		searchTextField.sendKeys(searchString);
		//WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(searchSubmitLocator));
		WebElement submit = webDriver.findElement(searchSubmitLocator);
		submit.click();
	}

	public WebDriver getDriver()
	{
		return webDriver;
	}
}
