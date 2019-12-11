package Unipupil.TestFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class AdminProfilePage extends UnipupilWebPage {

	// WebDriver driver;

	// WebElements
	WebElement sellingIcon;
	WebElement institutionBlock;
	WebElement storeMenuTitle;
	WebElement configurationMenuItem;
	WebElement commissionMenuItem;
	WebElement commissionInstitutionListMenuItem;
	WebElement overallCommissionMenuItem;
	WebElement popup;
	WebElement ordersMenuItem;
	WebElement viewOrdersMenuItem;
	WebElement orderDeleteIcon;
	WebElement confirmOrderDeleteButton;
	WebElement deletedMessage;

	List<WebElement> ordersTableRows;

	String homePageUrl = "https://unipupil.com";
	//String userProfilePageUrl = "https://unipupil.com/en/users/moranj";
	String userProfilePageUrl = "https://unipupil.com/user";

	// Locator variables
	// String myAccountXpath = ".//*[@id='block-block-7']/div/div/span[2]/a";
	By storeMenuLocator = 
			By.cssSelector("ul#admin-menu-menu > li:nth-of-type(1) > a");
	By configurationMenuItemLocator = 
			By.cssSelector("ul#admin-menu-menu > li:nth-of-type(1) > ul > li:nth-of-type(6) > a");
	By commissionMenuItemLocator = 
			By.cssSelector("ul#admin-menu-menu > li:nth-of-type(1) > ul > li:nth-of-type(6) "
					+ "> ul > li:nth-of-type(6) > a");
	By commInstListMenuItemLocator = 
			By.cssSelector("ul#admin-menu-menu > li:nth-of-type(1) > ul > li:nth-of-type(6) "
					+ "> ul > li:nth-of-type(6) > ul > li:nth-of-type(1) > a");
	By OverallCommissionMenuItemLocator = 
			By.cssSelector("ul#admin-menu-menu > li:nth-of-type(1) > ul > li:nth-of-type(6) "
					+ "> ul > li:nth-of-type(6) > ul > li:nth-of-type(3) > a");
	//By popupLocator = By.cssSelector("a.message-close");
	By ordersMenuItemLocator = 
			By.cssSelector("ul#admin-menu-menu > li:nth-of-type(1) > ul > li:nth-of-type(1) > a");
	By viewOrdersMenuItemLocator = 
			By.cssSelector("ul#admin-menu-menu > li:nth-of-type(1) > ul > li:nth-of-type(1) > ul > li:nth-of-type(1) > a");
	By ordersTableRowsLocator = 
			By.cssSelector("table.views-table.sticky-enabled.cols-6.tableheader-processed.sticky-table > tbody > tr");
	By orderNumberLocator = By.cssSelector("td.views-field.views-field-order-id.active > a");
	By orderDeleteLocator = 
			By.cssSelector("td.views-field.views-field-actions > a:nth-of-type(4) > img");
	By confirmDeleteLocator = By.cssSelector("div#edit-actions > input");
	By deletedMessageLocator = By.cssSelector("div.messages.status");

	// By variables
	// By myaccount = By.xpath(myAccountXpath);
	By logout = By.linkText("Logout");
	// By sellingicon = By.xpath(sellingIconXpath);

	Actions builder;

	// Page default constructor
	public AdminProfilePage() {
		System.out.println("AdminProfilePage default constructor");
	}

	// Page constructor
	public AdminProfilePage(WebDriver driver) {
		super(driver);
		System.out.println("AdminProfilePage constructor");
		builder = new Actions(driver);
		// super.driver = driver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

	/*
	 * public void getCourseList() { sellingIcon =
	 * webDriver.findElement(By.xpath(sellingIconXpath)); sellingIcon.click(); }
	 */

	public void findElements() {
		//closePopup();
		storeMenuTitle = wait.until(ExpectedConditions
				.presenceOfElementLocated(storeMenuLocator));
		ordersMenuItem = wait.until(ExpectedConditions
				.presenceOfElementLocated(ordersMenuItemLocator));
		viewOrdersMenuItem = wait.until(ExpectedConditions
				.presenceOfElementLocated(ordersMenuItemLocator));
		configurationMenuItem = webDriver
				.findElement(configurationMenuItemLocator);
		commissionMenuItem = webDriver.findElement(commissionMenuItemLocator);
		commissionInstitutionListMenuItem = webDriver
				.findElement(commInstListMenuItemLocator);
		overallCommissionMenuItem = webDriver
				.findElement(OverallCommissionMenuItemLocator);
		ordersMenuItem = webDriver.findElement(ordersMenuItemLocator);
		
	}

	/*public void closePopup() {
		popup = wait.until(ExpectedConditions
				.presenceOfElementLocated(popupLocator)); // By.xpath(popupXpath));
		popup.click();
	}*/

	public void openCommissionInstitutionsPage() {
		builder.moveToElement(storeMenuTitle).perform();
		builder.moveToElement(configurationMenuItem).perform();
		builder.moveToElement(commissionMenuItem).perform();
		commissionInstitutionListMenuItem.click();
	}

	public void openOverallCommissionPage() {
		builder.moveToElement(storeMenuTitle).perform();
		builder.moveToElement(configurationMenuItem).perform();
		builder.moveToElement(commissionMenuItem).perform();
		overallCommissionMenuItem.click();
	}

	public void deleteOrder(String orderID) {
		WebElement orderNumber;
		builder.moveToElement(storeMenuTitle).perform();
		builder.moveToElement(ordersMenuItem).perform();
		viewOrdersMenuItem.click();
		ordersTableRows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(ordersTableRowsLocator));
		System.out.println("ordersTableRows size: "+ordersTableRows.size());
		for(WebElement orderTableRow : ordersTableRows){
			orderNumber = orderTableRow.findElement(orderNumberLocator);
			System.out.println("orderID: "+orderID +" orderNumber: "+orderNumber.getText());
			if(orderNumber.getText().toUpperCase().equals(orderID)){
				orderDeleteIcon = orderTableRow.findElement(orderDeleteLocator);
				break;
			}
		}
		orderDeleteIcon.click();
		confirmOrderDeleteButton = wait.until(ExpectedConditions
				.presenceOfElementLocated(confirmDeleteLocator));
		confirmOrderDeleteButton.click();
		deletedMessage = webDriver.findElement(deletedMessageLocator);
		if(deletedMessage.isDisplayed()){
			System.out.println(deletedMessage.getText());
		}
	}

	public String getProfilePageUrl() {
		return userProfilePageUrl;
	}

	/*
	 * public void clickMyAccount(){ webDriver.findElement(myaccount).click(); }
	 */

	public void clickLogout() {
		webDriver.findElement(logout).click();
	}

}
