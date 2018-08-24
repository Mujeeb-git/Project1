package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class ParallelTwo {

WebDriver driver;
	
@Test
public void test_02() throws Exception {
	
	System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe");
	WebDriver driver = new InternetExplorerDriver();	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	driver.get("https://www.google.co.in");
	System.out.println("entered the url");
	Thread.sleep(5000);
	driver.findElement(By.id("lst-ib")).sendKeys("ParallelTwo"+Keys.ENTER);
	System.out.println("entered in the search box");
	
}
}
