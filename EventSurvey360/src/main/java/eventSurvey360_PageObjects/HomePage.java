package eventSurvey360_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	// WebElements of Home Page
	@FindBy(xpath = "//a[text()=' Login ']")
	public WebElement loginLnk;

	@FindBy(xpath = "//a[text()=' Register ']")
	public WebElement registerLnk;

	@FindBy(xpath = "//a[text()=' Create a survey ']")
	public WebElement createSurveyLnk;

	// constructor for initializing the objects
	public HomePage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all public WebElements
		PageFactory.initElements(driver, this);
	}

}
