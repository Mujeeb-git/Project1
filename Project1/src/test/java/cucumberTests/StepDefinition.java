package cucumberTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

 

public class StepDefinition {
	 WebDriver dr;
	 
    @Given("^sample feature file is ready$")
    public void givenStatment(){
           System.out.println("Given statement executed successfully");
    }
    @When("^I run the feature file$")
    public void whenStatement(){
           System.out.println("When statement execueted successfully");
    }
    @Then("^run should be successful$")
    public void thenStatment(){
           System.out.println("Then statement executed successfully");
    }
    
    
    //second
       
    @Given("^navigate to Gmail page$")
    public void navigate(){
    		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chomedriver.exe");
           dr=new ChromeDriver();
           dr.get("http://www.gmail.com");         
           }
    @When("^user logged in using username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void login(String username,String password){
           dr.findElement(By.xpath("//*[@id='Email']")).sendKeys(username);
           dr.findElement(By.xpath("//*[@id='Passwd']")).sendKeys(password);
           dr.findElement(By.xpath("//*[@id='signIn']")).click();
           dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
           }
    @Then("^home page should be displayed$")
    public void verifySuccessful(){
          String expectedText="Gmail";
          String actualText=         dr.findElement(By.xpath("//*[@id='gbq1']/div/a/span")).getText();
          Assert.assertEquals("Login not successful",expectedText.equals(actualText));
          }

    
    
}