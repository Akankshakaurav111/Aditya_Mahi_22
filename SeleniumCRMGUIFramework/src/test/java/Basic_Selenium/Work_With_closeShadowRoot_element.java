package Basic_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Work_With_closeShadowRoot_element {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver(); 
driver.get("https://demoapps.qspiders.com/ui/shadow/closed?sublist=1");
Thread.sleep(2000);
//login Attached text
driver.findElement(By.xpath("//h1[text()='Login']")).click();



	}

}
