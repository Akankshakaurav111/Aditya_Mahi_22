package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class CreateProjectAndVerifyDataInDBWithGUI {

	public static void main(String[] args) throws SQLException {
		//create project in GUI Using Selenium code
		Random ramdom=new Random();
		 int randomData = ramdom.nextInt(1000);

		String projectName="Instragrame_"+randomData;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		driver.get("http://106.51.90.215:8084/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		//driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("deepak s");
		Select sel=new Select(driver.findElement(By.name("status")));
		sel.selectByIndex(0);
		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		//Verify the project in Backend [DB] using JDBS 
		Connection conn=null;
		try
		{
		boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
		System.out.println("---Done------");
		Statement stat=conn.createStatement();
		 ResultSet result = stat.executeQuery("select * from project");
		 while(result.next())//next() use for come up next row 
			{
			String actualProjectName=result.getString(4);
			
			if(projectName.equals(actualProjectName))
			{
				flag=true;
				System.out.println(projectName+" is avilable====Pass");
			}
			}
		
		
		 if(flag==false)
		 {
			 System.out.println(projectName+"is not avilable ==Fail");
			 
		 }
			
		}
		catch(Exception e) {}
		finally {
			conn.close();
		}

	}
	}
	


