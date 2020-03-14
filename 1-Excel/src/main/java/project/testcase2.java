package project;


import org.testng.SkipException;
import project.Utility;
public class testcase2 extends Utility {

	public static void display (String status) throws Exception
	{
		
		if(status.toString().equals("true"))
		{
			//System.out.println("Executed: Test Case 2");
			openBrowser();
		}
		else {
			throw new SkipException("Skipping - This is not ready for testing ");
		}

	}

}
