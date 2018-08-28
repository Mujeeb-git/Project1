package packageTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class HelperClass {

	public static int currentHour() {

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

		Calendar calobj = Calendar.getInstance();

		int hr = Integer.parseInt(df.format(calobj.getTime()).toString().substring(9, 11));

		System.out.println("The current hour is:" + hr);
		return hr;
	}

	public static void markAttendance(WebDriver driver, String xpath1) throws Exception {

		driver.findElement(By.xpath(xpath1)).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.navigate().refresh();
		// record time
		Thread.sleep(2000);

	}

	public static String getMarkedTime(WebDriver driver, String xpath2) throws Exception {

		// record time
		Thread.sleep(2000);
		/*
		 * driver.findElement(By.id("aid")).click(); Thread.sleep(2000);
		 */
		driver.findElement(By.xpath("//*[@id='pageWrap']/div/ul/li[1]/div/table/tbody/tr/td/a")).click();
		Thread.sleep(2000);
		String message = driver.findElement(By.xpath(xpath2)).getText();

		return message;

	}
	
	public static void takeScreenshot(WebDriver driver) throws Exception {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\mujeeb.mohammed\\Pictures\\attendanceScreenshots\\ITP_"+dateString2()+".png"));
	}

	// Retrieve current date in the yyyyMMddHHmmss format
		public static String dateString2() {
			// Date to String
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();
			String d = dateFormat.format(date);
			// Reporter.log("The current date is "+d,true);
			return d;

		}

}
