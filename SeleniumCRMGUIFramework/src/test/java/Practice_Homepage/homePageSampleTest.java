package Practice_Homepage;

import java.lang.reflect.Method;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class homePageSampleTest {
	@Test
	public void homePagetest(Method mdt) {
		System.out.println(mdt.getName() + "Test Start");
		SoftAssert soft=new SoftAssert();
		
		System.out.println("step-1");
		System.out.println("step-2");
		soft.assertEquals("Home", "Home");
		//Assert.assertEquals("Home-page","Home");
		System.out.println("step-3");
		soft.assertEquals("Home-CRM", "Home-CRM-1");
		soft.assertAll();
		//Assert.assertEquals("Home-crm","Home-crm");
		System.out.println("step-4");
		
		}
	@Test
	public void homeLogoVerify(Method mdt) {
		System.out.println(mdt.getName() + "Test Start");
		SoftAssert soft=new SoftAssert();

		System.out.println("step-5");
		System.out.println("step-7");
	//	Assert.assertTrue(true);
		soft.assertTrue(true);
		soft.assertAll();
		System.out.println("step-3");
		
		System.out.println("step-4");
		
		}
}
