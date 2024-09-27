package practise.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReport {
	ExtentReports report;
	
	@BeforeSuite
	public void beforeSuiteConfi() {
		//spark repot congif
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("Crm Report");
		spark.config().setTheme(Theme.DARK);
		
		//Add ENV information and create test
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
		report.setSystemInfo("OS", "Windows-10");

	}
@Test
public void createContactTest() {
	
	//spark repot congif
/*	ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
	spark.config().setDocumentTitle("CRM Test Suite Results");
	spark.config().setReportName("Crm Report");
	spark.config().setTheme(Theme.DARK);
	
	//Add ENV information and create test
	ExtentReports report=new ExtentReports();
	report.attachReporter(spark);
	report.setSystemInfo("OS", "Windows-10");
	report.setSystemInfo("BROWSER", "CHROME-100");
	report.setSystemInfo("OS", "Windows-10");  */
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	TakesScreenshot eDriver=(TakesScreenshot)driver;
	String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
	
	//create the test inside of extentReports
	ExtentTest test=report.createTest("createContactTest");
	test.log(Status.INFO,"login to App");
	test.log(Status.INFO,"Navigate to Contact Page");
	test.log(Status.INFO,"Create Contact");
	if("HDFCe".equals("HDFC"))
	{
		test.log(Status.PASS, "Contact is created");
	}else {
		test.addScreenCaptureFromBase64String(filePath, "ErrorFile");
	//test.log(Status.FAIL,"Contact is not created");
}
}
@Test
public void createContactWithPhoneTest() {
ExtentTest test=report.createTest("createContactWithPhoneTest");
test.log(Status.INFO,"login to App");
test.log(Status.INFO,"Navigate to Contact Page");
test.log(Status.INFO,"Create Contact");
if("HDFCE".equals("HDFCE"))
{
	test.log(Status.PASS, "Contact is created");
}else {
test.log(Status.FAIL,"Contact is not created");
}
}

@Test
public void createContactWithOrgTest() {
ExtentTest test=report.createTest("createContactWithOrgTest");
test.log(Status.INFO,"login to App");
test.log(Status.INFO,"Navigate to Contact Page");
test.log(Status.INFO,"Create Contact");
if("HDFCE".equals("HDFCE"))
{
	test.log(Status.PASS, "Contact is created");
}else {
test.log(Status.FAIL,"Contact is not created");
}
}

	@AfterSuite
	public void afterCongif() {
	report.flush();
	}
	
}

