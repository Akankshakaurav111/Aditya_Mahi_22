package Assignment;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_ICCCricket {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.icc-cricket.com/");
		driver.findElement(By.xpath("//a[@alt='Rankings']")).click();
		
		driver.findElement(By.xpath("//h3[text()=\"Men's team rankings\"]/../following-sibling::div[@class='si-body']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Accept All Cookies']")).click();
		//driver.findElement(By.xpath("//h3[text()=\"Men's team rankings\"]/../following-sibling::div[@class='si-body']")).click();
		////div[@class='si-table swiper-slide']/descendant::h4/../following-sibling::div/div/descendant::span[@class="si-country"]
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='si-table-body']/div/div/following-sibling::div/descendant::span[@class='si-country']"));
           List<WebElement> points = driver.findElements(By.xpath("//div[@class='si-table-body']/descendant::span[text()='124']"));
	for(WebElement name:names)
	{
		String teamName = name.getText();
		for(WebElement point:points)
		{
			String pointNo=point.getText();
			System.out.println(teamName+"   "+pointNo);
			}
		}
	
	
	
	}

}
