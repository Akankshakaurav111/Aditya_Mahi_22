package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class useTryCatchINDataScript {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try
		{
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		 conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/tekp","root@%","root");
		System.out.println("---Done------");
		Statement stat=conn.createStatement();
		 ResultSet result = stat.executeQuery("select * from tp07");
		// result.getString(1);//read 1st row
		while(result.next())//next() use for come up next row 
		{
			result.getString(1);   //read all row 1st column;
		}
		}catch(Exception e) {
			System.out.println("Exception handle here");
		}
		finally {
		conn.close();
		System.out.println("====Connection is close ======");
		}
	}

	}

	


