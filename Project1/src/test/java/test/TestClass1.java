package test;

import org.testng.annotations.Test;

import utilityLibrary.ExcelOperations;

public class TestClass1 {
	ExcelOperations objEO;
	@Test
	public void method1() {
		
		objEO  = new ExcelOperations();
		
		for(int i=0;i<10;i++) {
			
			System.out.println(objEO.readExcel("Sheet1", i, 0)+"\n");
		}
		
	}

}
