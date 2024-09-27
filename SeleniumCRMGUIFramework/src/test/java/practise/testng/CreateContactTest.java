package practise.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactTest {
@Test(dataProvider="getData")
public void createContact(String FirstName,String LastName)
{
	System.out.println("FirstName  "+FirstName +"  LastName   "+LastName);
}

@DataProvider
public Object[][] getData(){
	Object[][] objArr=new Object[3][2];
	objArr[0][0]="Deepak";
	objArr[0][1]="hr";
	objArr[1][0]="ram";
	objArr[1][1]="hs";
	objArr[2][0]="mohan";
	objArr[2][1]="D";
	return objArr;
}
}
