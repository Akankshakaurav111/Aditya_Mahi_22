package pacticeAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.Crm.generic.baseUtility.BaseClassTest;

public class createContactTest extends BaseClassTest{
@Test
public void createContectTest()
{
	System.out.println("Createcontact will get excuted");
}
@Test
public void createContectWithPhoneTest()
{
	System.out.println("CreatecontactWithPhoneNumber will get excuted");
}

}
