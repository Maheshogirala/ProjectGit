package java.Textcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Base {

public static WebDriver dr;

@BeforeClass

public void browserinvock() {
	dr= new ChromeDriver();
	dr.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	dr.manage().window().maximize();
	dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	System.out.println(dr.getTitle());
}

@AfterClass
public void closebrowser() {
	dr.close();
}


public String screenshot(String tname) throws IOException {
	// tiemstamp
	
	String timestamp= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
	// screen shot
	TakesScreenshot ts= (TakesScreenshot)dr;
	File source= ts.getScreenshotAs(OutputType.FILE);
	String Destination= System.getProperty("user.dir")+"/screenshot/"+timestamp+tname+"img1.png";
	try {
	FileUtils.copyFile(source, new File(Destination));
	}catch(Exception e) {
		e.getStackTrace();
	}
	
	return Destination;
	
	
}



	
}
