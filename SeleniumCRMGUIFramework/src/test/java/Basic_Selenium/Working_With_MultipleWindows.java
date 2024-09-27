package Basic_Selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_MultipleWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(2000);
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.linkText("Facebook")).click();
		
		Set<String> windows = driver.getWindowHandles();
		for(String win:windows) {
			driver.switchTo().window(win);
			if(driver.getTitle().contains("Facebook"))
			{
				driver.findElement(By.xpath("//span[text()='See more on Facebook']/../../following-sibling::div[2]/descendant::label/input[@name='email']")).sendKeys("jyoti20@gmail");
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		Thread.sleep(2000);
			}
		}

	}

}
