package Basic_Selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Working_With_TakeScreenShot {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver() ;
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	//Type cast to get the capalities of TakeScreenShot interFace
	//to the driver instance
	TakesScreenshot ts=(TakesScreenshot)driver;
	=ts.getScreenshotAs(OutputType.FILE);
	//this is temparary location store temp location
	//copy that from temp to where you want this file remove the temp location 
	
	


}
}
