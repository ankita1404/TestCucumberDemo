/* Utility class for delaying program by 250 ms
 * 
 * @author Joseph Lalor
 * 
 */
package Unipupil.TestFramework.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindElement 
{
	String programClassName = "FindElement";
	
	public FindElement(){
		System.out.println(programClassName+" default constructor");
	}

	public static WebElement findElement(WebDriver driver, By by){
		System.out.println("Running FindElement.findElement");
		System.out.println("Parameters " + driver + " " + by.toString());
		WebElement webElement;
		webElement = driver.findElement(by);
		while(!(webElement.isDisplayed())){
			System.out.println("Finding element");
			ThreadSleep.sleep();
		}
		return webElement;
	}
}