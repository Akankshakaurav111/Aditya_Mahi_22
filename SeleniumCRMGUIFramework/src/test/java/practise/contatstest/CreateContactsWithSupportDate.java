package practise.contatstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactsWithSupportDate {
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
				 Sheet sh = wb.getSheet("Contact");
				 Row row = sh.getRow(4);
				 String lastName = row.getCell(2).toString()+randomInt;
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
				    
				//NAVIGATE TO CONTACTS MODUL
				    driver.findElement(By.linkText("Contacts")).click();
		       
				    //CLICK ON CONTACTS BUTTON
				    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				    Date dateobj=new Date();
				    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
				    String startDate=sim.format(dateobj);
				    System.out.println(startDate);
				    
				    Calendar cal = sim.getCalendar();//CAPTURE THE FULL CALANDAR
				    cal.add(Calendar.DAY_OF_MONTH,30);//GIVE THE AFTER AND BEFORE DATE
				   String endDate = sim.format(cal.getTime());
				   System.out.println(endDate);
				    
				
			  //ENTER THE LASTNAME
				    driver.findElement(By.name("lastname")).sendKeys(lastName);
				    
				   //start date
				    driver.findElement(By.name("support_start_date")).clear();
				    driver.findElement(By.name("support_start_date")).sendKeys(startDate);
					   
				    //endDate
				    driver.findElement(By.name("support_end_date")).clear();
				    driver.findElement(By.name("support_end_date")).sendKeys( endDate);
				    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				    
		     
			//verfy the start date	   
				   String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				   if(actStartDate.equals(startDate)) {
					   System.out.println(actStartDate+" information is verified===> PASS");
				   }else {
				   System.out.println(actStartDate+" information is not verified===>FAIL ");
				   }
				//verify the end date   
				   String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				   if(actEndDate.equals(endDate)) {
					   System.out.println(actEndDate+" information is verified===> PASS");
				   }else {
				   System.out.println(actEndDate+" information is not verified===>FAIL ");
				   }
				   driver.quit();
	}

}
