package pacticeAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class createLastName {
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before4 Class");
	}
	@Test
	public void createContacTest()
	{
		System.out.println("Create2 Name ");
	}
	@AfterSuite
	public void suiteTest()
	{
		System.out.println("After4 Suite");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before4 method");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after4 method");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("after4 Class");
	}
	@AfterClass
	public void afterClass3()
	{
		System.out.println("after6 Class");
	}
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before4 Suite");
	}
	@BeforeClass
	public void beforeClass3()
	{
		System.out.println("Before6 Class");
	}
	public void beforeClass2()
	{
		System.out.println("Before5 Class");
	}
	@Test
	public void createContacTest1()
	{
		System.out.println("Create Last1 ");
	}
	@AfterSuite
	public void suiteTest2()
	{
		System.out.println("After5 Suite");
	}
	@BeforeMethod
	public void beforeMethod2()
	{
		System.out.println("Before5 method");
	}
	@AfterMethod
	public void afterMethod2()
	{
		System.out.println("after5 method");
	}
	@AfterClass
	public void afterClass2()
	{
		System.out.println("after5 Class");
	}
	@BeforeSuite
	public void beforeSuite2()
	{
		System.out.println("Before5 Suite");
	}
}
