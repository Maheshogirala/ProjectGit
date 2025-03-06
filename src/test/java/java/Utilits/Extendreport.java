package java.Utilits;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extendreport implements ITestListener {
   // defind the extent method
	public ExtentSparkReporter sp;
	public ExtentReports report;
	public ExtentTest test;
	
	String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
	public void onStart(ITestContext context) {
	    // create time stamp
	
		// set the document location
		sp = new ExtentSparkReporter(System.getProperty("user.dir")+"/Extendreports/"+timestamp+"ext1.html");
		                                              // ("user.dir")+"/extendreport/"+"timestamp"+"E2.html
		// title of the page
		sp.config().setDocumentTitle("Regrution Test");
		sp.config().setReportName("Test Execution report");
		sp.config().setTheme(Theme.STANDARD);
		
		// Set the commoun values
	    report = new ExtentReports();
		report.attachReporter(sp);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Tester name", "mahesh");
		
		
		
	  }
	
	 public void onTestSuccess(ITestResult result) {
		    // not implemented
		 test= report.createTest(result.getName());
		 test.log(Status.PASS, "Test passed");
		 	 	 
		  }
	
	 public void onTestFailure(ITestResult result) {
		    // not implemented
		 
		 test= report.createTest(result.getName());
		 test.log(Status.FAIL ,result.getName()+"Test fail");
		 
		 try {
			String imagepath= new java.Textcases.Base().screenshot(result.getName());
			
			test.addScreenCaptureFromPath(imagepath);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 		  
		 
		  }
	 
	 public void onTestSkipped(ITestResult result) {
		    // not implemented
		 
		 test= report.createTest(result.getName());
		 test.log(Status.SKIP, "Test skiped");
		 
		 
		  }
	 
	 
	 public void onFinish(ITestContext context) {
	    // not implemented
		 report.flush();
		 
		 
	  }
	
	
}
