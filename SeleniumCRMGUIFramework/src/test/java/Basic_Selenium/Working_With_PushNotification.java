package Basic_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;

public class Working_With_PushNotification {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//this can be handle the chromeOptions class
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(options) ;
		driver.manage().window().maximize();
		
		//this can be handle the chromeOptions class
		driver.get("https://www.easemytrip.com/");

		Thread.sleep(2000);
	}

}
