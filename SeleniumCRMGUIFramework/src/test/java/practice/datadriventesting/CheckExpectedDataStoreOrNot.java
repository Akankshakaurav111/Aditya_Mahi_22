package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class CheckExpectedDataStoreOrNot {
@Test
	public void projectcheckTest() throws SQLException {
	String expectedRes="aditya";
	
	boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://Ninza-HRM:3333/tekp","root@%","root");
		System.out.println("---Done------");
		Statement stat=conn.createStatement();
		 ResultSet result = stat.executeQuery("select * from tp07");
		 while(result.next())//next() use for come up next row 
			{
			String actualRes=result.getString(1);
			System.out.println(actualRes);
			if(expectedRes.equals(actualRes))
			{
				flag=true;
				System.out.println(expectedRes+" is avilable====Pass");
			}
			}
		 if(flag==false)
		 {
			 System.out.println(expectedRes+"is not avilable ==Fail");
			 Assert.fail();
		 }
			conn.close();
			


	}

}
