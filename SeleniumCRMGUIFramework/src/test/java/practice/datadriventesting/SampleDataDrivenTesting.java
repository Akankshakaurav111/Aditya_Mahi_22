package practice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
		
		//step 1: get the java repesentation object of the physical file
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		
		// Step 2: using properties class,load all the keys
		Properties pobj=new Properties();
		pobj.load(fis);
		
      //Step 3: get the value based on keys
		
		System.out.println(pobj.getProperty("browser"));
		System.out.println(pobj.getProperty("url"));
		
		System.out.println(pobj.getProperty("username"));
		System.out.println(pobj.getProperty("password"));
	}

}
