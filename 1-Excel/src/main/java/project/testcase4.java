package project;
import project.Utility;

import org.testng.SkipException;

public class testcase4 extends  Utility{
	public static void display(String status) throws Exception
	{
		
		if(status.toString().equals("true"))
		{
			//System.out.println("Executed: Test Case 3");
			openBrowser();
			//int a = 10/0;
		}
		else {
			throw new SkipException("Skipping - This is not ready for testing ");
		}

	}


}
