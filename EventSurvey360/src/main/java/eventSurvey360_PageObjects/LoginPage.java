package eventSurvey360_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	// WebElements of Home Page
	@FindBy(xpath = "//*[@id='txtusername']")
	public WebElement userNameTxtbx;

	@FindBy(xpath = "//*[@id='txtpassword']")
	public WebElement passwordTxtbx;

	@FindBy(xpath = "//*[@id='aloginbutton']")
	public WebElement loginBtn;
	
	@FindBy(xpath = "//a[text()='Forgot password?']")
	public WebElement forgotPwdLnk;
	
	@FindBy(xpath = "//*[@id='tabs-inner']/div[7]/div/label/div/i")
	public WebElement staySignedInChkbx;
	
	@FindBy(xpath = "//a[text()='Sign Up ']")
	public WebElement signUpLnk;

	// constructor for initializing the class objects
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all public WebElements
		PageFactory.initElements(driver, this);
	}

	public void login(String userName, String password) {
		userNameTxtbx.sendKeys(userName);
		passwordTxtbx.sendKeys(password);
		loginBtn.click();
	}
}
