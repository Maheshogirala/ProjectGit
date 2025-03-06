package java.Textcases;



import java.Pageobjectives.Loginpage;

import org.testng.annotations.Test;

public class Logintc2 extends Base {
    
	@Test
	public void TC1() {
		Loginpage lp= new Loginpage(dr);
		lp.username("Admin");
		lp.password("admin123");
		lp.login();
	}
	
	
}
