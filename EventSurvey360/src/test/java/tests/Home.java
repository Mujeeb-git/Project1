package tests;

import java.util.ArrayList;
import java.util.Base64;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import eventSurvey360_PageObjects.HomePage;
import eventSurvey360_PageObjects.LoginPage;
import utilityLibrary.Helper;

public class Home {
	WebDriver driver;
	HomePage objHomePage;
	LoginPage objLoginPage;

	@BeforeClass
	public void setUp() throws Exception {
		// Open the application under test
		driver = Helper.openAUT(driver);
		objHomePage = new HomePage(driver);
		objLoginPage = new LoginPage(driver);
		

	}

	@Test(priority = 1, description = "Verify the home page links")
	public void testCase_01() throws Exception {
		Assert.assertTrue(objHomePage.loginLnk.isDisplayed());
		Assert.assertTrue(objHomePage.registerLnk.isDisplayed());
		Assert.assertTrue(objHomePage.createSurveyLnk.isDisplayed());
		Helper.takeScreenshot(driver);
	}
	
	
	@Test(priority = 2, description = "Verify the loginlink")
	public void testCase_02() throws Exception {
		objHomePage.loginLnk.click();
		Thread.sleep(5000);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertEquals(driver.getTitle(), Helper.getDFDData(2, "LoginPage"));
		// use https://www.base64encode.org/ for encoding and decoding creds
		objLoginPage.login(Helper.getValue("userName"),
				(new String(Base64.getDecoder().decode(Helper.getValue("password")))));
		Thread.sleep(2000);
		Helper.takeScreenshot(driver);
		

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
