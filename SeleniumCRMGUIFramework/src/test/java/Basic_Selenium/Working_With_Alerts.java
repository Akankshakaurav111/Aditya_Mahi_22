package Basic_Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_Alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver() ;
driver.manage().window().maximize();
driver.get("https://demowebshop.tricentis.com/");

Thread.sleep(2000);
driver.findElement(By.xpath("//input[@type='submit']")).click();



Thread.sleep(2000);
//control comes to alert
Alert alt = driver.switchTo().alert();
alt.accept();//alert is handle
System.out.println(" ----Alert is handle----");
driver.findElement(By.id("small-searchterms")).sendKeys("mobile");
	}

}
