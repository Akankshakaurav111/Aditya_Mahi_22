package Basic_Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_Alerts_Dismiss {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver() ;
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/delete_customer.php");

		Thread.sleep(2000);
		driver.findElement(By.name("cusid")).sendKeys("345632");
		driver.findElement(By.name("submit")).click();
		Alert alt = driver.switchTo().alert();
		alt.dismiss();
		System.out.println("---Alerts handles---");
		driver.quit();
		
		
		

	}

}
