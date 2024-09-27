package Practice_Homepage;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageReporterLogs {
	@Test
	public void homePagetest(Method mdt) {
		Reporter.log(mdt.getName() + "Test Start");
		SoftAssert soft=new SoftAssert();
		
		Reporter.log("step-1",true);
		Reporter.log("step-2",true);
		soft.assertEquals("Home", "Home");
		//Assert.assertEquals("Home-page","Home");
		Reporter.log("step-3",true);
		soft.assertEquals("Home-CRM1", "Home-CRM");
		
		//Assert.assertEquals("Home-crm1","Home-crm");
		Reporter.log("step-4");
		soft.assertAll();
		
		}
	@Test
	public void homeLogoVerify(Method mdt) {
		Reporter.log(mdt.getName() + "Test Start");
		SoftAssert soft=new SoftAssert();

		Reporter.log("step-5",true);
		Reporter.log("step-7",true);
	//	Assert.assertTrue(true);
		soft.assertTrue(true);
	
		Reporter.log("step-3",true);
		soft.assertAll();
		//Reporter.log("step-4");
	}	
}
