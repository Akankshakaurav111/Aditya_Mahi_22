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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class createeOrganizationWithIndustries {

	public static void main(String[] args) throws IOException, InterruptedException {
		//READ THE DATA FROM PROPERTIES FILE
		FileInputStream fis =new FileInputStream("./src/test/resources/commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
		
		//Create RANDOM NUMBER
		Random random = new Random();
		int randomInt=random.nextInt(1000);
		//READ THE DATA FROM EXCEL FILE
		FileInputStream fis1=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\SeleniumCRMGUIFramework\\src\\test\\resources\\Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(4);
		String orgname = row.getCell(2).getStringCellValue()+randomInt;
		String induestry = row.getCell(3).getStringCellValue();
		String type = row.getCell(4).getStringCellValue();
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
      //LOGIN TO APPLICATION
		 driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			Thread.sleep(2000);
		    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		    Thread.sleep(2000);
		    driver.findElement(By.id("submitButton")).click();
		    Thread.sleep(2000); 
		    
	 //NAVIGATE TO ORGANIZATION MODULE
		    driver.findElement(By.linkText("Organizations")).click();
		
		    
	//CLICK ON CREATE ORGANIZATION BUTTON
		    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		    
		    //ENTER ALL THE DETAILS AND CREATE NEW ORGANIZATION
		    driver.findElement(By.name("accountname")).sendKeys(orgname);
		   WebElement wbSel1 = driver.findElement(By.name("industry"));
		   Select sel1=new Select(wbSel1);
		    sel1.selectByVisibleText(induestry);
		    
		    WebElement wbsel2=driver.findElement(By.name("accounttype"));
		    Select sel2=new Select(wbsel2);
		    sel2.selectByVisibleText(type);
		    
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
    //VERIFY THE INDUSTRIES AND TYPE INFO
		   String actInadustry = driver.findElement(By.id("dtlview_Industry")).getText();
		   if(actInadustry.equals(induestry))
		   {
			   System.out.println(actInadustry+" information is verified ==>PASS");
		   }else {
			   System.out.println(actInadustry+" information is not verified ==>FAIL");
		   }
		   
		   String actType=driver.findElement(By.id("dtlview_Type")).getText();
		   if(actType.equals(type)) {
			   System.out.println(actType+" information is verified====>PASS");
		   }
		   else {
			   System.out.println(actType+" information is not verified====>FAIL");
		   }
		   driver.quit();
		    
	}

}
