package com.Crm.generic.baseUtility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassTest {
	@BeforeMethod
	public void createBeforeMathod()
	{
		System.out.println("Before method will get excuted");
		System.out.println("==Login The Application=====");
	}
	@AfterMethod
	public void createAfetrMathod()
	{
		System.out.println("Afoter method will get excuted");
		System.out.println("==LogOut The Application=====");
	}
	@BeforeClass
	public void createBeforeClassTest()
	{
		System.out.println("BeforeClass will get excuted");
		System.out.println("==Launch the Browser=====");
	}
	@AfterClass
	public void createAfterClassTest()
	{
		System.out.println("AfterClass will get excuted");
		System.out.println("==Close the Browser=====");
	}
	@BeforeSuite
	public void createBeforeSutiTest()
	{
		System.out.println("BeforeSuite will get excuted");
		System.out.println("==Connect to DB,Report =====");
	}
	@AfterSuite
	public void createAfterSutiTest()
	{
		System.out.println("AfterSuite will get excuted");
		System.out.println("==DisConnect to DB,Report back =====");
	}
}
