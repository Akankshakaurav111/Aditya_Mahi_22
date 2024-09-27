package pacticeAnnotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class createName {
	@BeforeClass
	public void beforeClass()
	{
		System.out.println("Before Class");
	}
	@Test
	public void createContacTest()
	{
		System.out.println("Create Contact ");
	}
	@AfterSuite
	public void suiteTest()
	{
		System.out.println("After Suite");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Before method");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("after Class");
	}
	@AfterClass
	public void afterClass3()
	{
		System.out.println("after3 Class");
	}
	@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("Before Suite");
	}
	@BeforeClass
	public void beforeClass3()
	{
		System.out.println("Before3 Class");
	}
	public void beforeClass2()
	{
		System.out.println("Before2 Class");
	}
	@Test
	public void createContacTest1()
	{
		System.out.println("Create Contact1 ");
	}
	@AfterSuite
	public void suiteTest2()
	{
		System.out.println("After2 Suite");
	}
	@BeforeMethod
	public void beforeMethod2()
	{
		System.out.println("Before2 method");
	}
	@AfterMethod
	public void afterMethod2()
	{
		System.out.println("after2 method");
	}
	@AfterClass
	public void afterClass2()
	{
		System.out.println("after2 Class");
	}
	@BeforeSuite
	public void beforeSuite2()
	{
		System.out.println("Before2 Suite");
	}
}
