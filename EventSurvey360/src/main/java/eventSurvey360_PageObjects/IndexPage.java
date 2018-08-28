package eventSurvey360_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver driver;
	Actions action;

	// WebElements of Home Page
	@FindBy(xpath = "//*[@id='header']/div[3]/div/div[4]/a/span")
	public WebElement userDrpdwnLnk;

	@FindBy(xpath = "//*[@id='header']/div[3]/div/div[4]/div/ul/li[5]/a")
	public WebElement logoutLnk;

	

	// constructor for initializing the objects
	public IndexPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all public WebElements
		PageFactory.initElements(driver, this);
	}

	//logout of the portal
	public void logout(WebDriver driver) throws Exception {
		userDrpdwnLnk.click();
		Thread.sleep(2000);
		logoutLnk.click();		
	}
}
