package practise.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithMob {
	public class CreateContactWithMobTest {
		@Test(dataProvider="getData")
		public void createContact(String FirstName,String LastName,long Mob)
		{
			System.out.println("FirstName  "+FirstName +"  LastName   "+LastName+"mobile no :"+Mob);
		}

		@DataProvider
		public Object[][] getData(){
			Object[][] objArr=new Object[2][3];
			objArr[0][0]="Deepak";
			objArr[0][1]="hr";
			objArr[0][2]=907896904905l;
			objArr[1][0]="ram";
			objArr[1][1]="hs";
		   objArr[1][2]=65789895938l;
			return objArr;
		}
}
}
