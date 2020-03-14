package project;
import project.ObjectAction;

public class ObjectMethod {

	public static void enterUsername() 
	{
		CommonAction.SendKeys(ObjectAction.enterUsername(), "Enter Username" , "bhimchawhan");
	}
	
	public static void enterPassword() 
	{
		CommonAction.SendKeys(ObjectAction.enterPassword(), "Enter Password" , "Some Password");
	}
	
	
	public static void ClickLoginButton() 
	{
		CommonAction.ClickButton(ObjectAction.enterPassword(),"Click on Login Button");
	}
	
}
