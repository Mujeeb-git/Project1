package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataDrivenTests {
	WebDriver driver;
	ExcelOperations objEO;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com");
		objEO= new ExcelOperations();
	}

	@Test
	public void searchFlight() throws Exception {
		String fromCity = objEO.readExcel("Sheet1", 1, 0);
		String toCity = objEO.readExcel("Sheet1", 1, 1);
		driver.findElement(By.xpath("//*[@id='js-switch__option']/div[1]/label")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='hp-widget__sfrom']")).clear();
		driver.findElement(By.xpath("//*[@id='hp-widget__sfrom']")).sendKeys(fromCity);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='hp-widget__sTo']")).sendKeys(toCity);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='searchBtn']")).click();
		Thread.sleep(5000);
		List<WebElement> airlineList = new ArrayList<WebElement>();
		airlineList = driver.findElements(By.xpath("//*[@id='content']/div/div[6]/div[5]/div[2]/div/div/div[2]/div[1]/span[1]/span[2]/span[1]"));
		
		List<WebElement> priceList = new ArrayList<WebElement>();
		priceList = driver.findElements(By.xpath("//*[@id='content']/div/div[6]/div[5]/div[2]/div/div/div[2]/div[6]/p[1]/span[2]"));
		
		objEO.createWorkBook();
		objEO.createSheet("Flight Details");
		//Create header
		objEO.createRow(0);
		objEO.writeExcelHeader("Flight Name", 0, 0);
		objEO.writeExcelHeader("Price",0, 1);

		int i=1;
		for(WebElement e: airlineList) {
			
			System.out.println("AirLine: "+e.getText()+"\t Price: "+priceList.get(i-1).getText());
			objEO.createRow(i);
			objEO.writeExcel(e.getText(), i, 0);
			objEO.writeExcel(priceList.get(i-1).getText(),i, 1);
			
			i++;
		}
		
		
		
		
		
		

	}
}
