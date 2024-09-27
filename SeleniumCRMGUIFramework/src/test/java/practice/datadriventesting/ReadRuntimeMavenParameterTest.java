package practice.datadriventesting;

import org.testng.annotations.Test;

public class ReadRuntimeMavenParameterTest {
@Test
public void runtimeParameterTest()
{
	String url=System.getProperty("url");
	String password=System.getProperty("password");
	String username=System.getProperty("username");
	String Browser=System.getProperty("browser");
System.out.println("EVN====> URL===>"+url);	
System.out.println("password====> URL===>"+password);	


System.out.println("username====> URL===>"+username);	
System.out.println("browser====> URL===>"+Browser);	

}
}
