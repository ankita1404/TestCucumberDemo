package Unipupil.TestFramework.pageObjects;

import java.math.BigDecimal;
/*import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Iterator;
import java.util.List;*/



import java.math.RoundingMode;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;*/




import Unipupil.TestFramework.pageObjects.UnipupilWebPage;
//import Unipupil.TestFramework.pageObjects.CartLineItems.CartCourseAdditionalFeesLineItem;

public class OverallCommissionPage extends UnipupilWebPage {
	
	//WebDriver webDriver;
	//Web elements
	WebElement institutionIDElement;
	WebElement institutionNameElement;
	WebElement shopProductPercentElement;
	WebElement domesticCommissionPercentElement;
	WebElement internationalCommissionPercentElement;
	WebElement agentCommissionPercentElement;
	WebElement updateButton;
	WebElement adminLogoutLink;
	
	//Xpaths
	By shopProductPercentLocator = By.cssSelector("input#edit-shop-prod");
	By internationalCommissionPercentLocator = By.cssSelector("input#edit-in-class");
	By domesticCommissionPercentLocator = By.cssSelector("input#edit-dom-class");
	By agentCommissionPercentLocator = By.cssSelector("input#edit-agent-commission");
	By updateButtonLocator = By.cssSelector("input#edit-submit");
	By adminLogoutLinkLocator = By.cssSelector("ul#admin-menu-account > li:nth-of-type(1) > a");
	
	//String adminProfilePageURL = "https://unipupil.com/en/users/joseph";
	//String commissionInstitutionListURL = "http://a.b.c.77/en/admin/store/settings/set_commission/list";
	//String commissionInstitutionListURL = "https:/unipupil.com/en/admin/store/settings/set_commission/list";
	//String institutionID = "101468770";
	//String institutionName = "Unipupil University (Sample)";
	String shopProductCommissionPercentText;
	String domesticCommissionPercentText;
	String internationalCommissionPercentText;
	String agentCommissionPercentText;
	
	BigDecimal shopProductCommissionPercent;
	BigDecimal domesticCommissionPercent;
	BigDecimal internationalCommissionPercent;
	BigDecimal agentCommissionPercent;
    
	String[] tokens;
	
	//Boolean agentStudent;
	
	public OverallCommissionPage()
	{
		System.out.println("OverallCommissionPage default constructor");
	}
	
	public OverallCommissionPage(WebDriver driver)
	{
		super(driver);
		System.out.println("OverallCommissionPage constructor");
	}
	
	public void findWebElements()
	{
		System.out.println("Running OverallCommissionPage.findWebElements()");
		shopProductPercentElement = webDriver.findElement(shopProductPercentLocator);
		shopProductCommissionPercent = new BigDecimal(shopProductPercentElement.getAttribute("value"));
		domesticCommissionPercentElement = webDriver.findElement(domesticCommissionPercentLocator);
		System.out.println("domesticCommissionText "+domesticCommissionPercentElement.getAttribute("value"));
		domesticCommissionPercent = new BigDecimal(domesticCommissionPercentElement.getAttribute("value"));
		internationalCommissionPercentElement = webDriver.findElement(internationalCommissionPercentLocator);
		System.out.println("internationalCommissionText "+internationalCommissionPercentElement.getAttribute("value"));
		internationalCommissionPercent = new BigDecimal(internationalCommissionPercentElement.getAttribute("value"));
		agentCommissionPercentElement = webDriver.findElement(agentCommissionPercentLocator);
		System.out.println("agentCommissionText "+agentCommissionPercentElement.getAttribute("value"));
		agentCommissionPercent = new BigDecimal(agentCommissionPercentElement.getAttribute("value"));
		updateButton = webDriver.findElement(updateButtonLocator);
		adminLogoutLink = webDriver.findElement(adminLogoutLinkLocator);
	}
	
	
	public BigDecimal calcAgentCommissionDomestic(BigDecimal basicFee)
	{
		BigDecimal agentCommissionPercent;
		BigDecimal agentCommission;
		agentCommissionPercent = this.agentCommissionPercent.divide(new BigDecimal(100)).multiply(
				                 domesticCommissionPercent.divide(
				                 new BigDecimal(100)));
		System.out.println("agentCommissionPercent: " + agentCommissionPercent);
		
		agentCommission = (basicFee.multiply(agentCommissionPercent)).setScale(2,RoundingMode.HALF_UP);	
		System.out.println("agentCommission: " + agentCommission);
		return agentCommission;
	}
	
	public BigDecimal calcAgentCommissionInternational(BigDecimal basicFee)
	{
		BigDecimal agentCommissionPercent;
		BigDecimal agentCommission;
		agentCommissionPercent = this.agentCommissionPercent.divide(new BigDecimal(100)).multiply(
				                 internationalCommissionPercent.divide(
				                 new BigDecimal(100)));
		System.out.println("agentCommissionPercent: " + agentCommissionPercent);
		
		agentCommission = (basicFee.multiply(agentCommissionPercent)).setScale(2,RoundingMode.HALF_UP);	
		System.out.println("agentCommission: " + agentCommission);
		return agentCommission;
	}
	
	public BigDecimal calcInstitutionCommissionDomestic(BigDecimal basicFee)
	{
		BigDecimal institutionCommission;
		BigDecimal institutionCommissionPercent;
		institutionCommissionPercent = (new BigDecimal(100).subtract(
				                       this.agentCommissionPercent)).divide(
				                       new BigDecimal(100)).multiply(
				                       domesticCommissionPercent.divide(
				                       new BigDecimal(100)));
		System.out.println("agentCommissionPercent: " + agentCommissionPercent);
		
		institutionCommission = (basicFee.multiply(institutionCommissionPercent)).setScale(2,RoundingMode.HALF_UP);
		System.out.println("institutionCommission: " + institutionCommission);
		return institutionCommission;
	}
	
	public BigDecimal calcInstitutionCommissionInternational(BigDecimal basicFee)
	{
		BigDecimal institutionCommission;
		BigDecimal institutionCommissionPercent;
		institutionCommissionPercent = (new BigDecimal(100).subtract(
				                       this.agentCommissionPercent)).divide(
				                       new BigDecimal(100)).multiply(
				                       internationalCommissionPercent.divide(
				                       new BigDecimal(100)));
		System.out.println("agentCommissionPercent: " + agentCommissionPercent);
		
		institutionCommission = (basicFee.multiply(institutionCommissionPercent)).setScale(2,RoundingMode.HALF_UP);
		System.out.println("institutionCommission: " + institutionCommission);
		return institutionCommission;
	}
	
	public BigDecimal calcTotalCommissionDomestic(BigDecimal basicFee)
	{
		BigDecimal totalCommission;
		totalCommission = (domesticCommissionPercent.divide(
				          new BigDecimal(100)).multiply(basicFee)).setScale(2,RoundingMode.HALF_UP);
		System.out.println("totalCommission: " + totalCommission);
		return totalCommission;
	}
	
	public BigDecimal calcTotalCommissionInternational(BigDecimal basicFee)
	{
		BigDecimal totalCommission;
		totalCommission = (internationalCommissionPercent.divide(
				          new BigDecimal(100)).multiply(basicFee)).setScale(2,RoundingMode.HALF_UP);
		System.out.println("totalCommission: " + totalCommission);
		return totalCommission;
	}

	public BigDecimal getShopProductCommissionPercent()
	{
		return shopProductCommissionPercent;
	}
	
	public BigDecimal getDomesticCommissionPercent()
	{
		return domesticCommissionPercent;
	}
	
	public BigDecimal getInternationalCommissionPercent()
	{
		return internationalCommissionPercent;
	}
	
	public BigDecimal getAgentCommissionPercent()
	{
		return agentCommissionPercent;
	}
	
	public BigDecimal getInstitutionCommissionPercent()
	{
		return (new BigDecimal(100)).subtract(agentCommissionPercent);
	}
	
	public void logout()
	{
		
		adminLogoutLink = webDriver.findElement(adminLogoutLinkLocator);
		//webDriver.findElement(By.linkText("Log out")).click();
		adminLogoutLink.click();
	}
	
	/*public void setAgentStudent(Boolean agentStudent)
	{
		this.agentStudent = agentStudent;
	}*/
	
}
