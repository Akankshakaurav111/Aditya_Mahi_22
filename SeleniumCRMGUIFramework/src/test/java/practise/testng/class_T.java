package practise.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class class_T {
	@BeforeSuite
	public void classBS1()
	{
		System.out.println("Classs t Before suite 1");
		
	}
	@AfterSuite
	public void classAS1()
	{
		System.out.println("Classs t After suite 1");
		
	}
	@BeforeClass
	public void classBC1()
	{
		System.out.println("Classs t Before Class 1");
		
	}
	@AfterClass
	public void classAC1()
	{
		System.out.println("Classs t After Class 1");
		
	}

	public void classAM1()
	{
		System.out.println("Classs t After Method 1");
		
	}
	@BeforeMethod
	public void classBM1()
	{
		System.out.println("Classs t Before Method 1");
		
	}

	@BeforeSuite
	public void classBS2()
	{
		System.out.println("Classs t Before suite 2");
		
	}
	@AfterSuite
	public void classAS2()
	{
		System.out.println("Classs t After suite 2");
		
	}
	@BeforeClass
	public void classBC2()
	{
		System.out.println("Classs t Before Class 2");
		
	}
	@AfterClass
	public void classAC2()
	{
		System.out.println("Classs t After Class 2");
		
	}

}
