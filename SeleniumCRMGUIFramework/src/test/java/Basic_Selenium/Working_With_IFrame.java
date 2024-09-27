package Basic_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_IFrame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.get("https://demoapps.qspiders.com/ui/frames?sublist=0");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		driver.findElement(By.id("username")).sendKeys("jyoti");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("kaurav1234");
		Thread.sleep(2000);
	
		driver.findElement(By.id("submitButton")).click();
		driver.switchTo().defaultContent();
		driver.close();
		
	}

}
