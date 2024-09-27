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

public class AmazonTvCheckBox {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/AmazonData.properties");
		
		   Properties pobj=new Properties();
			pobj.load(fis);
		  String  BROWSER= pobj.getProperty("browser");
			String URL = pobj.getProperty("url");
			String DATA=pobj.getProperty("data");
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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys(DATA);
	driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	Actions act=new Actions(driver);
	WebElement tvCheckBox = driver.findElement(By.xpath("//span[contains(text(),'Samsung')]/ancestor::li/descendant::div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']"));
      act.click(tvCheckBox).perform();
      
	}

}
