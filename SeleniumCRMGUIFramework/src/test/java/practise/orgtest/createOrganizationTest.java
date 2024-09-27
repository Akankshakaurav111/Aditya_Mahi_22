package practise.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//read the data from properties file
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		 Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		//generate random number
		Random ramdom=new Random();
		int randomInt = ramdom.nextInt(1000);
		
		// read the data from excel file
		FileInputStream fis1=new FileInputStream("C:\\Users\\Admin\\Desktop\\data\\testScript.xlsx");
		 Workbook wb = WorkbookFactory.create(fis1);
		 Sheet sh=wb.getSheet("org");
		 Row row=sh.getRow(1);
		 String orgname=row.getCell(2).getStringCellValue()+randomInt;
		 wb.close();
   WebDriver driver=null;
   if(BROWSER.equals("chrome")) {
	   driver=new ChromeDriver();
   }else if(BROWSER.equals("firefox"))
   {
	   driver=new FirefoxDriver();
   }else if(BROWSER.equals("edge"))
   {
	   driver=new EdgeDriver();
   }else {
	   driver=new ChromeDriver();
   }
   //login to app
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	Thread.sleep(2000);
    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    Thread.sleep(2000);
    driver.findElement(By.id("submitButton")).click();
    Thread.sleep(2000);
   
    //navigate to organization module
    driver.findElement(By.linkText("Organizations")).click();
    
    //navegate to create organization button
    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    
    //enter all the details and create new orgnazation
    driver.findElement(By.name("accountname")).sendKeys(orgname);
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    
    //verify the Header msg Expected Result
    String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    
    if(headerInfo.contains(orgname))
    {
    	System.out.println(orgname +" is created===>PASS");
    }
    else {
    	System.out.println(orgname+" is not created====>Fail");
    }
    
    
    // veerify the Header orgName info Expected Result
   String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
    if(actOrgName.equals(orgname))
    {
    	System.out.println(orgname+" is created===>PASS");
    }
    else {
    	System.out.println(orgname+"  is not created===>FAIL");
    }
    	
    	
    //logout
    driver.quit();

	

}}
