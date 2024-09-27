package Assignment;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProKabaddiTeamName5 {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./src/test/resources/AmazonData.properties");
		
		   Properties pobj=new Properties();
			pobj.load(fis);
		  String  BROWSER= pobj.getProperty("browser");
			String URL = pobj.getProperty("url3");
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.xpath("//div[@id='onetrust-close-btn-container']")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.scrollByAmount(0,2000).perform();
		
	List<WebElement> name = driver.findElements(By.xpath("//div[@class='row-head']/following::div[@class='team-name']"));
	List<WebElement> from = driver.findElements(By.xpath("//div[@class='row-head']/following::ul[@class='form-listing']"));
		int size1 = name.size();
		int size2=from.size();
	int j=0;
	String price="";
	String product="";
	for(WebElement ele:name)
	{
		for(WebElement ele1:from)
		{
		 product=	ele.getText();
		 price= ele1.getText();
		j++;
		}
		System.out.println(product +" : "+price);
	}
		
	

	}	
}	


