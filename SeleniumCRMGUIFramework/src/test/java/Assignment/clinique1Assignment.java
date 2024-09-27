package Assignment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class clinique1Assignment {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./src/test/resources/AmazonData.properties");
		
		   Properties pobj=new Properties();
			pobj.load(fis);
		  String  BROWSER= pobj.getProperty("browser");
			String URL = pobj.getProperty("url2");
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
			
		}else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}else
		{
			driver= new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.xpath("//button[text()='OK, ACCEPT ALL']")).click();
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		
		WebElement singIn = driver.findElement(By.xpath("//*[local-name()='svg' and @class='header-secondary-links-icon']/ancestor::div[@id='gnv-account-container']"));
		Thread.sleep(2000);
		singIn.click();
		
		
		
	}

}
