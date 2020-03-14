package project;
import project.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ObjectAction extends Utility{
	
	
	public static String enterUsername() {
		
		return(CommonAction.basiccheck(ObjectRepository.username,"Username checking"));
	}
	
	public static String enterPassword() {
		
		return(CommonAction.basiccheck(ObjectRepository.password,"Password checking"));
	}
	
	
	public static String ClickLoginButton() {
		
		return(CommonAction.basiccheck(ObjectRepository.loginbutton,"Login button checking"));
	}	

}
