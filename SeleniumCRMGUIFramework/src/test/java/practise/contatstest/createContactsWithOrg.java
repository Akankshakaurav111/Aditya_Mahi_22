package practise.contatstest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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

public class createContactsWithOrg {
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
		 Row row = sh.getRow(7);
		 String orgname = row.getCell(2).toString()+randomInt;
		 String lastName = row.getCell(3).toString()+randomInt;
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
		    
		    
		    // navigate to COntact link
			//NAVIGATE TO CONTACTS MODUL
		    driver.findElement(By.linkText("Contacts")).click();
       
		    //CLICK ON CONTACTS BUTTON
		    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();	
		
	  //ENTER THE LASTNAME
		    driver.findElement(By.name("lastname")).sendKeys(lastName);
		    
		    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		    
		//switch to child window
		     Set<String> set = driver.getWindowHandles();
		     Iterator<String> it = set.iterator();
		     while(it.hasNext())
		     {
		    	 String windowID=it.next();
		    	 driver.switchTo().window(windowID);
		    	 
		    	 String actUrl=driver.getCurrentUrl();
		    	 if(actUrl.contains("module=Accounts")) {
		    		 break;
		    	 }
		     }
		     
		    
		    
		    driver.findElement(By.name("search_text")).sendKeys(orgname);
		    driver.findElement(By.name("search")).click();
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		    
		    
		
		    
		    //come back to parent we use collection
		    Set<String> set1 = driver.getWindowHandles();
		     Iterator<String> it1 = set1.iterator();
		     while(it1.hasNext())
		     {
		    	 String windowID=it1.next();
		    	 driver.switchTo().window(windowID);
		    	 
		    	 String actUrl=driver.getCurrentUrl();
		    	 if(actUrl.contains("Contacts&action")) {
		    		 break;
		    	 }
		     }
		     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		    
     //VERIFY THE org  IN TEXTFIELD AND HEADER ALSO and use trim and equals()
	
	  headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    
	    if(headerInfo.contains(orgname))
	    {
	    	System.out.println(orgname +" is created===>PASS");
	    }
	    else {
	    	System.out.println(orgname+" is not created====>Fail");
	    }
	    
	    
	    // veerify the Header orgName info Expected Result
	    //VERIFY THE LASTNAME IN TEXTFIELD AND HEADER ALSO
		   String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		   if(actLastName.equals(lastName)) {
			   System.out.println(actLastName+" information is verified===> PASS");
		   }else {
		   System.out.println(actLastName+" information is not verified===>FAIL ");
		   }	
	
	    //logout
	    driver.quit();
}
				    	 
}		 
		 
		 
	



