package java.Pageobjectives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepom {
  public static WebDriver dr;
  
  public Basepom(WebDriver dr) {
	  this.dr=dr;
	  PageFactory.initElements(dr, this);
  }
	
	
}
