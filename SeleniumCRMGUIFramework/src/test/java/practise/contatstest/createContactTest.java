package practise.contatstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createContactTest {

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
				 Row row = sh.getRow(1);
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
				
			  //ENTER THE LASTNAME
				    driver.findElement(By.name("lastname")).sendKeys(lastName);
				    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				    
		     //VERIFY THE LASTNAME IN TEXTFIELD AND HEADER ALSO
				   String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
				   if(actLastName.equals(lastName)) {
					   System.out.println(actLastName+" information is verified===> PASS");
				   }else {
				   System.out.println(actLastName+" information is not verified===>FAIL ");
				   }
				   driver.quit();
	}

}
