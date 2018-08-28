package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eventSurvey360_PageObjects.HomePage;
import eventSurvey360_PageObjects.IndexPage;
import eventSurvey360_PageObjects.LoginPage;
import utilityLibrary.Helper;

public class Login {
	WebDriver driver;
	LoginPage objLoginPage;
	HomePage objHomePage;
	IndexPage objIndexPage;

	@BeforeClass
	public void setUp() throws Exception {
		// Open the application under test
		driver = Helper.openAUT(driver);
		objLoginPage = new LoginPage(driver);
		objHomePage = new HomePage(driver);
		objIndexPage = new IndexPage(driver);
	}

	@Test(priority = 1, description = "Verify whether user is able to login")
	public void testCase_01() throws Exception {
		objHomePage.loginLnk.click();
		Thread.sleep(20000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println("The number of windows are: "+tabs.size());
		driver.switchTo().window(tabs.get(1));

		// use https://www.base64encode.org/ for encoding and decoding creds
		objLoginPage.login(Helper.getValue("userName"),
				(new String(Base64.getDecoder().decode(Helper.getValue("password")))));
		Thread.sleep(10000);
		Helper.takeScreenshot(driver);
		Assert.assertEquals(driver.getTitle(), Helper.getDFDData(2, "LoginPage"));
		objIndexPage.logout(driver);
		Thread.sleep(5000);
	}

	@Test(priority = 2, description = "Verify whether the users are able to login", dataProvider = "loginData")
	public void testCase_02(String userName, String password) throws Exception {
		/*objHomePage.loginLnk.click();
		Thread.sleep(6000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));*/

		// use https://www.base64encode.org/ for encoding and decoding creds
		objLoginPage.login(userName, password);
		Thread.sleep(10000);
		Helper.takeScreenshot(driver);
		Assert.assertEquals(driver.getTitle(), Helper.getDFDData(2, "LoginPage"));
		objIndexPage.logout(driver);
		Thread.sleep(5000);
	}

	@DataProvider
	public Object[][] loginData() throws IOException {

		Object[][] data = { { Helper.getDFDData(5, "LoginPage"), Helper.getDFDData2(5, "LoginPage") },
				{ "user1", "password1" } };
		return data;
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

}
