package project;
import static org.testng.Assert.fail;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;

import project.ExcelTesting;
import project.ObjectRepository;


public class testcase1 extends Utility {

	public static void display (String status) throws Exception
	{
		
		if(status.toString().equals("true"))
		{
			
			
//			openBrowser();
//			
//			ObjectMethod.enterUsername();
//						
//			ObjectMethod.enterPassword();
//			
//			ObjectMethod.ClickLoginButton();
//			
//			Assert.fail();

			
		}
		else {
			throw new SkipException("Skipping - This is not ready for testing ");
		}

	}

}
