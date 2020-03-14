package project;

import org.testng.SkipException;

public class testcase3 extends Utility{

	public static void display(String status) throws Exception
	{
		
		if(status.toString().equals("true"))
		{
			//System.out.println("Executed: Test Case 3");
			openBrowser();
		}
		else {
			throw new SkipException("Skipping - This is not ready for testing ");
		}

	}

}
