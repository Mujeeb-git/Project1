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
	int count,max_attempt;
	@Test
	public void attendance() throws Exception {

		Properties prop = new Properties();
		
		count=0;
		max_attempt=5;
		

		File file = new File(System.getProperty("user.dir") + "//DataSource//Datafile.properties");

		FileInputStream fis = new FileInputStream(file);

		prop.load(fis);

		String userName = prop.getProperty("username");
		String password = prop.getProperty("password");
		String url = prop.getProperty("url");

		System.out.println("userName, " + userName + "\npassword, " + password + "\nurl :" + url);

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		try {
			Thread.sleep(10000);
			driver.findElement(By.name("userName")).sendKeys(userName);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.id("loginButton")).click();
			Thread.sleep(5000);
			HelperClass.takeScreenshot(driver);
			driver.findElement(By.id("aid")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='pageWrap']/div/ul/li[1]/div/table/tbody/tr/td/a")).click();
			Thread.sleep(2000);
			// mark attendance for morning or evening based on whether the current hour is
			// less than 10 or not
			if (HelperClass.currentHour() < 10) {
				// morning attendance:::
				String xpath2 = "//*[@id='col_center_big']/form/table/tbody/tr[3]/td[3]";
				String status = driver.findElement(By.xpath("//*[@id='col_center_big']/form/table/tbody/tr[3]/td[2]")).getText();
				if ((status.equalsIgnoreCase("Marked"))||(status.equalsIgnoreCase("Time Up"))||(status.equalsIgnoreCase("Not Opened"))) {
					// morning attendance already marked
					System.out.println("Attendance "+status+ ": " + HelperClass.getMarkedTime(driver, xpath2));
				} else {
					// morning attendance marking
					System.out.println("This is the morning session attendance");
					String xpath1 = "//*[@id='col_center_big']/form/table/tbody/tr[3]/td[2]/input";

					HelperClass.markAttendance(driver, xpath1);
					System.out.println("Attendance is marked successfully with timeStamp: "
							+ HelperClass.getMarkedTime(driver, xpath2));
				}
			} else {
				// evening attendance:::
				String xpath3= "//*[@id='col_center_big']/form/table/tbody/tr[3]/td[5]";
				String status2 = driver.findElement(By.xpath("//*[@id='col_center_big']/form/table/tbody/tr[3]/td[4]")).getText();
				if ((status2.equalsIgnoreCase("Marked"))||(status2.equalsIgnoreCase("Time Up"))||(status2.equalsIgnoreCase("Not Opened"))) {
					// evening attendance marked
					System.out.println("Attendance "+status2+ ": " + HelperClass.getMarkedTime(driver, xpath3));
				} else {
					// evening attendance marking
					System.out.println("This is the evening session attendance");
					String xpath1 = "//*[@id='col_center_big']/form/table/tbody/tr[3]/td[4]/input";
					HelperClass.markAttendance(driver, xpath1);
					System.out.println("Evening attendance Status is :"
							+ HelperClass.getMarkedTime(driver, xpath3));
				}

			}
			Thread.sleep(5000);
			HelperClass.takeScreenshot(driver);
			driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			Thread.sleep(5000);
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(++count>=max_attempt) throw e;
			else
			attendance();
			
		}		

	}
}
