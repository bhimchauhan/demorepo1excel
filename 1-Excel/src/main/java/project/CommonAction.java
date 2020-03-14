package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommonAction extends Utility {

	public static  void SendKeys(String object, String description, String testdata)
	{
		driver.findElement(By.id(object)).sendKeys(description);
	}
	
	public static  void ClickButton(String object, String description)
	{
		driver.findElement(By.xpath(object)).click();
	}
	
	
	
	public static String basiccheck(String object, String descrption)
	{
		try {
			driver.findElement(By.xpath(object)).isDisplayed();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return object;
	}
	
	
}
