package practice.datadriventesting;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SelectQueryMultipleDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/tekp","root@%","root");
		System.out.println("---Done------");
		Statement stat=conn.createStatement();
		 ResultSet result = stat.executeQuery("select * from tp07");
		 while(result.next())//next() use for come up next row 
			{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3));
			}
			conn.close();
			

	}	

	}

	



