package packageTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
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

}
