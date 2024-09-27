package practice.datadriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ExcutionNonSelectQurey {

	public static void main(String[] args) throws SQLException {
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/tekp","root@%","root");
		System.out.println("---Done------");
		Statement stat=conn.createStatement();
		 int result = stat.executeUpdate("insert into tp07 values(9,'Ram','java',4");
   System.out.println(result);
			
			conn.close();
			
	}

	}


