package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment_CreateOrgnition {

	public static void main(String[] args) throws IOException, InterruptedException {
	FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
    Properties pobj=new Properties();
    pobj.load(fis);
    String BROWSER = pobj.getProperty("browser");
    String URL = pobj.getProperty("url");
    String USERNAME = pobj.getProperty("username");
    String PASSWORD= pobj.getProperty("password");
    
    WebDriver driver=null;
    if(BROWSER.equals("chrome"))
    {
    	driver=new ChromeDriver();
    }
    else if(BROWSER.equals("firefox"))
    	{
    	driver=new FirefoxDriver();
    	}
    else if(BROWSER.equals("edge"))
    {
    	driver=new EdgeDriver();
    }
    else
    {
    	driver=new ChromeDriver();
    }
    driver.get(URL);
    driver.findElement(By.name("user_name")).sendKeys(USERNAME);
    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    driver.findElement(By.id("submitButton")).click();
    driver.findElement(By.linkText("Organizations")).click();
    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
    driver.findElement(By.name("accountname")).sendKeys("mahi2315Tech");
    driver.findElement(By.name("button")).click();
   //String title = driver.getTitle();
  // System.out.println(title);
  // Thread.sleep(5000);
   //driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(); 
   Thread.sleep(2000);
   //String pagesource = driver.getPageSource(); Thread.sleep(2000);
   //if(pagesource.contains("mahi2315Tech"))
   String heading=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
   if(heading.contains("mahi2315Tech"))
   {
	   System.out.println("it means new Mahi2313 organitions is created sucessfully");
   }
   else
   {
	   System.out.println(" test script is fail");
   }
	}

}
