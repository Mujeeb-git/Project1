package packageTest;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
	WebDriver driver;

	@Test
	public void attendance() throws Exception {
		
		Properties prop = new Properties();
		
		File file = new File(System.getProperty("user.dir") + "//DataSource//Datafile.properties");

		FileInputStream fis = new FileInputStream(file);
		
		prop.load(fis);
		
		String userName = prop.getProperty("username");
		String password = prop.getProperty("password");
		String url = prop.getProperty("url");
		
		System.out.println("userName, "+userName+"\npassword, "+password+"\nurl :"+url);
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(10000);
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("aid")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='pageWrap']/div/ul/li[1]/div/table/tbody/tr/td/a")).click();
		Thread.sleep(2000);
		
		if(HelperClass.currentHour()<10) {
			String xpath2 = "//*[@id='col_center_big']/form/table/tbody/tr[3]/td[3]";
			if(driver.findElement(By.xpath("//*[@id='col_center_big']/form/table/tbody/tr[3]/td[2]")).getText()=="Marked") {
				System.out.println("Attendance is already marked at: "+HelperClass.getMarkedTime(driver, xpath2));
			}
			System.out.println("This is the morning session attendance");
			String xpath1 = "//*[@id='col_center_big']/form/table/tbody/tr[3]/td[2]/input";
			
			HelperClass.markAttendance(driver, xpath1);			
			System.out.println("Attendance is marked successfully with timeStamp: "+HelperClass.getMarkedTime(driver, xpath2));
		}
		else {
			String xpath2 = "//*[@id='col_center_big']/form/table/tbody/tr[3]/td[5]";
			if(driver.findElement(By.xpath("//*[@id='col_center_big']/form/table/tbody/tr[3]/td[2]")).getText()=="Marked") {
				System.out.println("Attendance is already marked at: "+HelperClass.getMarkedTime(driver, xpath2));
			}
			System.out.println("This is the evening session attendance");
			String xpath1 = "//*[@id='col_center_big']/form/table/tbody/tr[3]/td[4]/input";
			HelperClass.markAttendance(driver, xpath1);			
			System.out.println("Attendance is marked successfully with timeStamp: "+HelperClass.getMarkedTime(driver, xpath2));
			
			
		}
		
	}
}
