package practise.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import javax.swing.text.DateFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createOrganizationWithPhoneNumberTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// READ THE DATA FROM PROPERTY FILE
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		//GENERATE THE RENDAM NUMBER
		Random random=new Random();
		int randomInt = random.nextInt(100);
		
		//READ THE DATA FROM EXCEL FILE
		FileInputStream fis1=new FileInputStream("src\\test\\resources\\Testdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		 Sheet sh = wb.getSheet("org");
		 Row row = sh.getRow(7);
		 String orgname = row.getCell(2).toString()+randomInt;
		  Cell cell = row.getCell(3);


		 
		 //CREATE DATAFORMATTER OBJECT AND INVOKE THE CELL OBJECT FOR NUMARIC VALUE INTO STRING FORMATE
		  DataFormatter data = new DataFormatter();
		 String phoneNumber=data.formatCellValue(cell);
				 wb.close();
		 //launch the BROWSER 
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
		    driver.findElement(By.id("phone")).sendKeys(phoneNumber);
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		 //VERIFY THE PHONENUMBER(ACTUAL AND EXCEL PH.NO)
		    String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
		    
		 if(actPhoneNumber.equals(phoneNumber))
		 {
			 System.out.println(actPhoneNumber+" is created======> PASS");
		 }
		 else {
			 System.out.println(actPhoneNumber+" is not created ===> FAIL");
		 }
		 
		 
		 
		 
	}

}
