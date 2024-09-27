package practise.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot_ScriptTest {
	@Test
	public void screenShot() throws IOException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	
	TakesScreenshot ts=(TakesScreenshot) driver;
	File tempScreenshot = ts.getScreenshotAs(OutputType.FILE);
	File permScreenshot = new File("./ScreenShot/Amazon.png");
	
	
	FileUtils.copyFile(tempScreenshot, permScreenshot);
	driver.manage().window().minimize();
	driver.quit();
	}
}
