package test;

import org.testng.annotations.*;

public class DataProviderTest {
	
	@DataProvider
	public Object[][] loginData(){
		
		Object[][] data = {
				{"userName1","password1"},
				{"userName2","password2"},
				{"userName3","password3"},
				{"userName4","password4"},
				{"userName5","password5"},
				{"userName6","password6"},
				
		};
		return data;
	}
	
	@Test(dataProvider = "loginData")
	public void test_01(String userName, String password) {
		System.out.println("UserName: "+userName+"\t\tPassword: "+password);		
		
	}

}
