package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {

	@Parameters({"userName","password"})
	@Test
	public void test_01(String userName, String password) {
		System.out.println("UserName: "+userName+"\t\tPassword: "+password);		
		
	}
}
