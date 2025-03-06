package java.Pageobjectives;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Basepom{

	public static WebDriver dr;
	
	public Loginpage(WebDriver dr) {
		
		super(dr);
		//this.dr=dr;
		
		//PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//input[@ name='username']") WebElement username;
	@FindBy(xpath="//input[@ name='p']") WebElement password;
	@FindBy(xpath="//button[@ type='submit']") WebElement submit;
	
	
	public void username(String user) {
		username.sendKeys(user);
	}
	
	public void password(String psd) {
		password.sendKeys(psd);
	}
	
	public void login() {
		submit.click();
	}
	
}
