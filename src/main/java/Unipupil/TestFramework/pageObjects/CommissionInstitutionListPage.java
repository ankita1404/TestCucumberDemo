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

public class CommissionInstitutionListPage extends UnipupilWebPage {
	
	//WebDriver webDriver;
	//Web elements
	WebElement institutionIDElement;
	WebElement institutionNameElement;
	WebElement shopProductPercentElement;
	WebElement domesticCommissionPercentElement;
	WebElement internationalCommissionPercentElement;
	WebElement agentCommissionPercentElement;
	WebElement editLink;
	WebElement deleteLink;
	WebElement adminLogoutLink;
	
	//Xpaths
	By institutionIDLocator = By.cssSelector("table#sort-table > tbody > tr > td:nth-of-type(2)");
	By institutionNameLocator = By.cssSelector("table#sort-table > tbody > tr > td:nth-of-type(3)");
	By shopProductPercentLocator = By.cssSelector("table#sort-table > tbody > tr > td:nth-of-type(4)");
	By internationalCommissionPercentLocator = By.cssSelector("table#sort-table > tbody > tr > td:nth-of-type(5)");
	By domesticCommissionPercentLocator = By.cssSelector("table#sort-table > tbody > tr > td:nth-of-type(6)");
	By agentCommissionPercentLocator = By.cssSelector("table#sort-table > tbody > tr > td:nth-of-type(7)");
	By editLinkLocator = By.cssSelector("table#sort-table > tbody > tr > td:nth-of-type(8) > a");
	By deleteLinkLocator = By.cssSelector("table#sort-table > tbody > tr > td:nth-of-type(9) > a");
	By adminLogoutLinkLocator = By.cssSelector("ul#admin-menu-account > li:nth-of-type(1) > a");
	
	String adminProfilePageURL = "https://unipupil.com/en/users/moranj";
	//String commissionInstitutionListURL = "http://a.b.c.77/en/admin/store/settings/set_commission/list";
	String commissionInstitutionListURL = "https:/unipupil.com/en/admin/store/settings/set_commission/list";
	String institutionID = "101468770";
	String institutionName = "Unipupil University (Sample)";
	String shopProductCommissionText;
	String domesticCommissionPercentText;
	String internationalCommissionPercentText;
	String agentCommissionPercentText;
	
	BigDecimal shopProductCommissionPercent;
	BigDecimal domesticCommissionPercent;
	BigDecimal internationalCommissionPercent;
	BigDecimal agentCommissionPercent;
    
	String[] tokens;
	
	//Boolean agentStudent;
	
	public CommissionInstitutionListPage()
	{
		System.out.println("CommissionInstitutionListPage default constructor");
	}
	
	public CommissionInstitutionListPage(WebDriver driver)
	{
		super(driver);
		System.out.println("CommissionInstitutionListPage constructor");
	}
	
	public void findWebElements()
	{
		System.out.println("Running CommissionInstitutionListPage.findWebElements()");
		institutionIDElement = webDriver.findElement(institutionIDLocator);
		institutionNameElement = webDriver.findElement(institutionNameLocator);
		shopProductPercentElement = webDriver.findElement(shopProductPercentLocator);
		domesticCommissionPercentElement = webDriver.findElement(domesticCommissionPercentLocator);
		domesticCommissionPercentText = domesticCommissionPercentElement.getText();
		System.out.println("domesticCommissionText "+domesticCommissionPercentText);
		domesticCommissionPercent = new BigDecimal(domesticCommissionPercentText);
		internationalCommissionPercentElement = webDriver.findElement(internationalCommissionPercentLocator);
		internationalCommissionPercentText = internationalCommissionPercentElement.getText();
		internationalCommissionPercent = new BigDecimal(internationalCommissionPercentText);
		agentCommissionPercentElement = webDriver.findElement(agentCommissionPercentLocator);
		agentCommissionPercentText = agentCommissionPercentElement.getText();
		System.out.println("agentCommissionText "+agentCommissionPercentText);
		agentCommissionPercent = new BigDecimal(agentCommissionPercentText);
		editLink = webDriver.findElement(editLinkLocator);
		deleteLink = webDriver.findElement(deleteLinkLocator);
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
