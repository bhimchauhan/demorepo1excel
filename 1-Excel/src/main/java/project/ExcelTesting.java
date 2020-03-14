package project;
import java.io.File;
import project.Utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExcelTesting extends Utility{
	static String [] strArray = new String[100];
	static ArrayList<String> list=new ArrayList<String>();
	
	ExtentReports report;
    ExtentTest logger;

    
    
	//Before Test
	@BeforeTest
	
	public void beforeTest() throws Exception {
		
		
		  report = new ExtentReports(".//test-report/" +"Report.html", true);  
		  report
		  
		  .addSystemInfo("Environment", "https://facebook.com")
	      .addSystemInfo("Host Name", "Demo")      
	      .addSystemInfo("User Name", "Windows");
	      
		  report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));	
		
		
				
		FileInputStream fis = new FileInputStream(".\\Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		Row row = null;
		Cell cell = null; 		
	
				
		int rowCount = sheet.getLastRowNum();
		
		//String[] strArray = new String[rowCount+1];
		
		for(int i= 1 ;i<rowCount+1;i++) {
					
			if(sheet.getRow(i).getCell(1).getStringCellValue().equals("true")) {
				
				row = sheet.getRow(i);
				//cell = sheet.getRow(i).getCell(2);
				cell = row.createCell(2);
				cell.setCellValue("Executed");
				strArray[i]="true";
			}
			
			else{
				
				//System.out.println(sheet.getRow(i).getCell(0)+" is not Executed" );
				
				row = sheet.getRow(i);
			   //cell = sheet.getRow(i).getCell(2);
				cell = row.createCell(2);
				cell.setCellValue("Not Executed");
				strArray[i]="false";
				
			}
		}
		 
		
		
		FileOutputStream outFile =new FileOutputStream(new File(".\\Test.xlsx"));
		workbook.write(outFile);
		outFile.close();

		
	}

	
	//Test Cases
	@Test
	public void testcase1() throws Exception {
		
		logger=report.startTest("Test Case 1");
		testcase1.display(strArray[1]);
	}
	
	
	@Test(enabled = true)
	public void testcase2() throws Exception{
		logger=report.startTest("Test Case 2");
		testcase2.display(strArray[2]);
	}
	
	
	@Test
	public void testcase3() throws Exception{
		logger=report.startTest("Test Case 3");
		testcase3.display(strArray[3]);
	}
	
	@Test
	public void testcase4() throws Exception{
		logger=report.startTest("Test Case 4");
		testcase4.display(strArray[4]);
	}
	
	//After Method
	@AfterMethod		
	public void afterMethod(ITestResult result) throws Exception {
		
		  		if(result.getStatus()==ITestResult.SUCCESS)
		  		{
		  			logger.log(LogStatus.PASS, "This test Case is Passed");
		  			list.add("PASSED");
		  			 driver.quit();	
		  		}
		  		else if(result.getStatus()==ITestResult.FAILURE)
		  		{
		  			logger.log(LogStatus.FAIL, "This test Case is Failed");	
		  			list.add("FAILED");
		  			 driver.quit();	
		  			
		  		}
		  		if(result.getStatus()==ITestResult.SKIP)
		  		{
		  			logger.log(LogStatus.SKIP, "This test Case is Skipped");
		  			list.add("SKIPPED");
		  			 driver.quit();	
		  		}
	       
		  		report.endTest(logger);
		  		System.out.println("*******************************************");
				System.out.println(logger.getTest().getName()+" EXECUTION STATUS--->"+logger.getTest().getStatus());
				System.out.println("*******************************************");
			    report.flush();
			    
			   
			    
			    

	}
		   
	
	 //After test
	@AfterTest public void afterTest() throws Exception {
//		for(String s: list) {
//			System.out.println(s);
//			
//		}

		
		FileInputStream fis = new FileInputStream(".\\Test.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row row = null;
		Cell cell = null; 		
			
		int rowCount = sheet.getLastRowNum();
		for(int i= 1 ;i<rowCount+1;i++) {
				row = sheet.getRow(i);
				cell = row.createCell(3);
				cell.setCellValue(list.get(i-1));
				
			
		}
		
		FileOutputStream outFile =new FileOutputStream(new File(".\\Test.xlsx"));
		workbook.write(outFile);
		outFile.close();
	
	}
	
	    
	@AfterSuite
	public void aftersuite()
	{
		report.close();
	}
	
	

}
