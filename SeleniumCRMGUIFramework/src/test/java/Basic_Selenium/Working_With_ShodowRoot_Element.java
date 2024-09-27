package Basic_Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_ShodowRoot_Element {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demoapps.qspiders.com/ui?scenario=1");
		driver.findElement(By.xpath("//section[contains(text(),'Shadow Root Elements')]")).click();
		driver.findElement(By.xpath("//section[text()='Shadow Root']")).click();
		Thread.sleep(2000);
		//shadow host--> identifiy shadow host
		SearchContext shadow_host = driver.findElement(By.xpath("//form/div[1]")).getShadowRoot();
		shadow_host.findElement(By.cssSelector("input[type='text']")).sendKeys("Pradyumna");
		
		SearchContext shadow_host2 = driver.findElement(By.xpath("//form/div[2]")).getShadowRoot();
		shadow_host2.findElement(By.cssSelector("input[type='text']")).sendKeys("Ramachandra");
	}

}
