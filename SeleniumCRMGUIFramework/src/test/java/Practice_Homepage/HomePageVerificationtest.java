package Practice_Homepage;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;





public class HomePageVerificationtest {
	@Test
	public void homePagetest(Method mdt) {
		System.out.println(mdt.getName() + "Test Start");
		String expectedPage = "Home";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actTitle = driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	/*	if (actTitle.trim().equals(expectedPage)) {
			System.out.println(expectedPage  + "  page is verified===PASS");
		} else {
			System.out.println(expectedPage  + "  page is not verified===FAIL");
		}  */
		
		//use hard Assert
		Assert.assertEquals(expectedPage, actTitle);
		driver.quit();
		System.out.println(mdt.getName() + "Test END");
	}

	@Test
	public void verifyLogoHomePageTest(Method mdt) {
		System.out.println(mdt.getName() + "Test Start");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status = driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
	/*	if (status) {
			System.out.println("Logo is verified ===PASS");
		} else {
			System.out.println("Logo is not verified ===FAIL");
		}  */
		
		//HardAssert
		Assert.assertTrue(status);

	}
}
